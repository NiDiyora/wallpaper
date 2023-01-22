package com.example.wallpaper.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import com.example.wallpaper.BuildConfig
import com.example.wallpaper.comman.AuthInterceptor
import com.example.wallpaper.data.dataSource.SecureStorageManager
import com.example.wallpaper.data.dataSource.remote.api.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    private val jsonConfig = Json {
        isLenient = true
        encodeDefaults = true
        ignoreUnknownKeys = true
    }
    @Provides
    @Singleton
    fun ProvideOkHttpBuilder(secureStorageManager: SecureStorageManager): OkHttpClient =
        with(OkHttpClient.Builder()) {
            callTimeout(30000, TimeUnit.SECONDS)
            connectTimeout(30000, TimeUnit.SECONDS)
            readTimeout(30000, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(interceptor)
            }
            addNetworkInterceptor(AuthInterceptor(secureStorageManager)).build()
        }


    @Provides
    @Singleton
    fun ProvideRetrofit(okHttpClient: OkHttpClient):Retrofit.Builder{
        val responseContentType = "application/json".toMediaType()
        val converterFactory = jsonConfig.asConverterFactory(responseContentType)
        return Retrofit.Builder().addConverterFactory(converterFactory).addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())

    }

    @Provides
    @Singleton
    fun ProviceApiService(retrfitBuilder: Retrofit.Builder): ApiService {
        return retrfitBuilder
            .baseUrl("https://api.pexels.com/v1/").build().create(ApiService::class.java)
    }


}