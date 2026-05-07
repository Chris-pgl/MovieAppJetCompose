package com.example.movieapp.navigation


/**
 * funziona simile a una route web
 * //www.google.com/sign_in
 */

/**
 * tolgo le enum per la sealed class per poter passare gli argument

enum class MovieScreens {
    HomeScreen,
    DetailsScreen;

    companion object{
        fun fromRoute(route: String?): MovieScreens
        = when (route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")

        }
    }
}
 */

sealed class MovieScreens(val route: String) {

    object Home : MovieScreens("home")

    object Details : MovieScreens("details")

    /**
     * Modo corretto
     object Details : MovieScreen("details/{movieName}") {

        fun passMovie(movieName: String): String {
            return "details/$movieName"
        }
    }
     */

}