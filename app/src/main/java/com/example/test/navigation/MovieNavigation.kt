package com.example.test.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.test.screens.detail.DetailScreen
import com.example.test.screens.favorite.FavoriteScreen
import com.example.test.screens.home.HomeScreen
import com.example.test.viewmodels.MovieViewModels

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()

    val movieViewModel: MovieViewModels = viewModel()

    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){

        composable(MovieScreens.HomeScreen.name){ HomeScreen(navController = navController, viewModel = movieViewModel)}
        composable(MovieScreens.DetailScreen.name + "/{movie}",
                arguments = listOf(navArgument("movie"){
                    type = NavType.StringType
                })
            ){backStackEntry ->

            backStackEntry.arguments?.getString("movie")
            DetailScreen(navController = navController,backStackEntry.arguments?.getString("movie"))
        }
        composable(MovieScreens.FavoriteScreen.name){ FavoriteScreen(navController = navController, viewModel = movieViewModel)}
        // add more routes and screens here
    }
}