package com.example.wallpaper.data.usecases

import com.example.wallpaper.comman.Resource
import com.example.wallpaper.comman.applyIO
import com.example.wallpaper.data.dataSource.repository.WallPaperRepository
import com.example.wallpaper.ktor.GetRepo
import com.example.wallpaper.ktor.model.Cultured
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class WallPaperUseCases @Inject constructor()  {

    operator fun invoke(page:Int,per_page:Int):Flow<Resource<Cultured>> = callbackFlow {
        try {
            trySend(Resource.Loading())
            trySend(Resource.Success(GetRepo().getWallPaper(page,per_page)))
        }catch (e:Exception){
            trySend(Resource.Error(e.message.toString()))
        }



//        getRepo.getWallPaper(page,per_page).applyIO().subscribe({
//            trySend(Resource.Success(it))
//        }, {
//
//        })
        awaitClose {
            close()
        }
    }
}