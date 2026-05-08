package com.example.movieapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navController: NavController,
    movieId: String?
) {

    val movie = getMovies().first { it.id == movieId }

    Box(modifier = Modifier.fillMaxSize()) {

        // BACKGROUND IMAGE
        Image(
            painter = rememberImagePainter(movie.poster),
            contentDescription = "Movie Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
                //blur sfoca il background davvero molto interessante
                //.blur(2.dp)
        )

        // DARK OVERLAY
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )

        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = { Text("Movie Details") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            }
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                MovieRow(movie = movie)

                Spacer(modifier = Modifier.height(20.dp))

                Divider()

                Text(
                    "Movie Images",
                    color = Color.White
                )

                HorizontalScrollableImageMovieView(listOf(movie))

                Button(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Text("Go Back")
                }
            }
        }
    }
}

@Composable
private fun HorizontalScrollableImageMovieView(newMovieList: List<Movie>){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
    items(newMovieList[0].images){ image ->
        Card(
            modifier = Modifier
                .width(300.dp)
                .height(180.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {

            Image(
                painter = rememberImagePainter(image),
                contentDescription = "Movie Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            }
        }
    }
}