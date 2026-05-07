package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.screens.details.DetailsScreen


/**
 * Funzione composable per la navigazione tra le schermate
 * qui definiamo da dove si parte e dove si arriva tra le schermate.
 * creiamo le varie root
 *
 * sono 3 i passaggi fondamentali per navigare tra le schermate:
 *
 * 1- NavController
 * 2- NavHost
 * 3- NavGraph/composable
 */
@Composable
fun MovieNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MovieScreens.Home.route
    ) {
        // qui passiamo le varie route tra le schermate
        composable(MovieScreens.Home.route) {
            // schermata Home
            HomeScreen(navController)

        }
        //passiamo i params = www.google.com/details/{id=34}
        composable(MovieScreens.Details.route+"/{movieName}",
            arguments = listOf(navArgument(name = "movieName"){
                type = NavType.StringType
            })
        ){
            backStackEntry ->

            DetailsScreen(
                navController,
                backStackEntry.arguments?.getString("movieName")
            )
        }
    }
}

