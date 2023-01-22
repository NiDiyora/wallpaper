package com.example.wallpaper

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.wallpaper.comman.NavigationGraph
import com.example.wallpaper.ktor.GetRepo
import com.example.wallpaper.ktor.WallpaperRemoteDataSource
import com.example.wallpaper.ktor.model.Photo
import com.example.wallpaper.ui.theme.WallPaperTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WallPaperTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
//                    LaunchedEffect(key1 = "", block ={
//                        CoroutineScope(Dispatchers.IO).launch{
//                       //     Log.d(TAG, "onCreate: ${WallpaperRemoteDataSource(GetRepo()).getWallPaper()} ")
//                        }
//                    } )

                    NavigationGraph(navController = rememberNavController(),this)
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WallPaperTheme {
        Greeting("Android")
    }
}