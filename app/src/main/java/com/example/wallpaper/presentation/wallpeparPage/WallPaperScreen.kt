package com.example.wallpaper.presentation.wallpeparPage

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.wallpaper.viewmodals.WallPaperViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WallPaperScreen(viewModel: WallPaperViewModel = hiltViewModel()) {
    Box {
        viewModel.setContextApp(LocalContext.current)
    }
    val wallPaperList = viewModel.getWallpaperListItem().observeAsState()
    if(wallPaperList.value != null) {


        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),

            // content padding
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
            content = {
                val wallpaper = wallPaperList.value
                if(wallpaper?.isNotEmpty() == true){
                itemsIndexed(items = wallpaper) { _,wallpaperItem ->
                    Card(
                        backgroundColor = Color.White,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                            .wrapContentHeight()
                            ,
                        elevation = 8.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        AsyncImage(
                            model = wallpaperItem.src?.large?.toUri(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }})
    }
}

@Preview()
@Composable
fun DefaultPriview(){
    WallPaperScreen()
}
