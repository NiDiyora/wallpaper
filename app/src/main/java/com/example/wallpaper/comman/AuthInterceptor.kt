package com.example.wallpaper.comman

import android.util.Log
import com.example.wallpaper.data.dataSource.ISecureStorageManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val secureStorageManager: ISecureStorageManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val token = secureStorageManager.token

        if (token.isNotEmpty()) {
            request = request.newBuilder()
                .addHeader("Authorization", "$token")
                .build()
        } else {
            request.newBuilder()
                .build()
        }
        return chain.proceed(request)
    }
}