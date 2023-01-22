package com.example.wallpaper.viewmodals

import android.annotation.SuppressLint
import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaper.WallPaperApp
import com.example.wallpaper.comman.Resource
import com.example.wallpaper.data.usecases.WallPaperUseCases
import com.example.wallpaper.database.AppDatabase
import com.example.wallpaper.database.WallPaperDao
import com.example.wallpaper.database.WallPaperDaoRepository
import com.example.wallpaper.ktor.model.Cultured
import com.example.wallpaper.ktor.model.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WallPaperViewModel @Inject constructor(private val wallPaperUseCases: WallPaperUseCases) :
    ViewModel() {

    val wallpaperList = MutableLiveData<List<Photo>>()
    @SuppressLint("StaticFieldLeak")
    var context: Context? = null
    var database:AppDatabase? =null

    init {
        //getWallPaper()
    }

    fun setContextApp(context: Context) {
        this.context = context
        database = context.let { it1 -> AppDatabase.getDataBase(it1) }
        getLocalCulturedWallpaper()

    }

    private fun getLocalCulturedWallpaper(){
        getWallPaper()
//         val repository by lazy {
//            database?.wallpaperDao()?.let {dao -> WallPaperDaoRepository(dao) }
//        }
//        repository?.getCulturedWallPaper()?.onEach {
//            wallpaperList.value = it.photos
//        }?.launchIn(viewModelScope)


    }

    fun getWallPaper() {
        wallPaperUseCases.invoke(1, 60).onEach {
            when (it) {
                is Resource.Error -> {
                    Log.d(TAG, "getWallPaper: ${it.message}")
                }
                is Resource.Loading -> {
                    Log.d(TAG, "getWallPaper: Loading........")

                }
                is Resource.Success -> {
//                    wallpaperList.value = it.data?.photos

                    it.data?.let { cultured ->
                         val repository by lazy {
                            database?.wallpaperDao()?.let {dao -> WallPaperDaoRepository(dao) }
                        }
                        viewModelScope.launch {
                            repository?.insertCulturedWallpaper(cultured)
                        }
                        repository?.getCulturedWallPaper()?.onEach {
                            wallpaperList.value = it.photos
                        }?.launchIn(viewModelScope)
                    }
                    Log.d(TAG, "getWallPaper: ${it.data}")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getWallpaperListItem(): MutableLiveData<List<Photo>> {
        return wallpaperList
    }

}