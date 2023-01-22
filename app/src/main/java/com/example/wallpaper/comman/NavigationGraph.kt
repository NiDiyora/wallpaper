package com.example.wallpaper.comman

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wallpaper.presentation.HomePage.MainScreen
import com.example.wallpaper.presentation.alaramManeger.AlarmManager
import com.example.wallpaper.presentation.homeDetailsScreen.HomeDetailsScreen
import com.example.wallpaper.presentation.stickyHeader.StickyHeader
import com.example.wallpaper.presentation.wallpeparPage.WallPaperScreen

sealed class Screens(val route: String) {
    object Home : Screens("Home")
    object HomeDetailsScreen : Screens("DetailsScreen/{$My_Arg}") {
        fun passArgument(message: String) = "DetailsScreen/$message"
    }

    object WallPaperScreen : Screens("WallpaperScreen")
    object StickyHeaderScreen :Screens("StickyHeaderScreen")
    object AlarmManagerScreen:Screens("AlarmManager")
}

const val MY_URI = "https://stevdza-san.com"
const val My_Arg = "message"

@SuppressLint("SuspiciousIndentation")
@Composable
fun NavigationGraph(navController: NavHostController,context: Context) {
    NavHost(navController = navController, startDestination = Screens.AlarmManagerScreen.route) {
        composable(Screens.Home.route) {
            MainScreen(navController = navController)
        }
        composable(
            Screens.HomeDetailsScreen.route,
            arguments = listOf(navArgument(My_Arg) { type = NavType.StringType }),
            deepLinks = listOf(
                navDeepLink { uriPattern = "$MY_URI/$My_Arg={$My_Arg}" })
        ) {
            val argument = it.arguments
            argument?.getString(My_Arg)?.let { message ->
                HomeDetailsScreen(message)
            }
        }
        composable(
            route = Screens.WallPaperScreen.route
        ){
            WallPaperScreen()
        }
        composable(
            route = Screens.StickyHeaderScreen.route) {
            StickyHeader()
        }
        composable(route = Screens.AlarmManagerScreen.route){
            AlarmManager(context = context)
        }

    }
}