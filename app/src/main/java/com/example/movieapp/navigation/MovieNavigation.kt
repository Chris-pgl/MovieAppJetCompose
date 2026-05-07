package com.example.movieapp.navigation

import android.graphics.Movie
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.screens.home.HomeScreen


/**
 * Funzione composable per la navigazione tra le schermate
 * qui definiamo da dove si parte e dove si arriva tra le schermate.
 * creiamo le varie root
 */
@Composable
fun MovieNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MovieScreens.Home.route
    ) {

        composable(MovieScreens.Home.route) {

            // schermata Home
            HomeScreen(navController)

        }

        composable(MovieScreens.Details.route){
            //schermata details
            //DetailsScreen()
        }
    }
}

