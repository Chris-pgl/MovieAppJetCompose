package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies


@Preview
@Composable
fun MovieRow(movie: Movie? = getMovies().firstOrNull(), onItemClick: (String)-> Unit = {} ){
    var exspanded = remember { mutableStateOf(false) }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        //.height(130.dp)

        .clickable {
            onItemClick(movie?.id ?: "No ID")
            println("Clicked on ${movie?.title}")
        },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        /*
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
         */
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 6.dp) {
                //usiamo la libreria 'coil' per gestire icon da url
                Image(
                    painter = rememberImagePainter(data = movie?.images?.first(),
                                                     builder = {
                                                         crossfade(true)
                                                         transformations()
                                                     }),
                    contentDescription = "Movie Poster")
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(movie?.title.toString(),
                   style = MaterialTheme.typography.titleMedium)
                Text("Director: ${movie?.director.toString()}",
                    style = MaterialTheme.typography.titleSmall)
                Text("Released: ${movie?.year.toString()}",
                    style = MaterialTheme.typography.titleSmall)
                /**
                 * Qui creo colum e icon arrow per epsandere la miniatur quando viene premuto per mostrare info
                 */
                AnimatedVisibility(visible = exspanded.value) {
                    Column() {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.LightGray,
                                fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.titleSmall.fontSize)){
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(color = Color.LightGray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Light)){
                                append(movie?.plot.toString())
                            }
                        }, modifier = Modifier.padding(6.dp))

                        Divider(modifier = Modifier.padding(3.dp))
                        /*
                        Text(text = "Director: ${movie?.director.toString()}",
                            style = MaterialTheme.typography.titleSmall)
                        Text(text = "Actors: ${movie?.actors.toString()}",
                            style = MaterialTheme.typography.titleSmall)
                         */
                        Text(text = "Genre: ${movie?.genre.toString()}",
                            style = MaterialTheme.typography.titleSmall)
                        Text(text = "Rating: ${movie?.rating.toString()}",
                            style = MaterialTheme.typography.titleSmall)
                    }
                }

                //Icon arrow down per mostrare ulterior info
                Icon(imageVector = if(exspanded.value) Icons.Filled.KeyboardArrowUp
                                    else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier.size(25.dp)
                        .clickable{
                            exspanded.value = !exspanded.value
                        },
                    tint = Color.DarkGray
                )

            }

        }


    }




}