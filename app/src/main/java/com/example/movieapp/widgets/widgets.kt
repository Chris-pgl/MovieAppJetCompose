package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
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

//TODO ctrl + E apri il percorso progetto e vedi tutte le class etc
@Preview
@Composable
fun MovieRow(
    movie: Movie? = getMovies().firstOrNull(),
    onItemClick: (String) -> Unit = {}
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie?.id ?: "")
            },

        shape = RoundedCornerShape(12.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        )
    ) {

        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.Top
        ) {

            // IMAGE
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp),

                shape = RoundedCornerShape(12.dp),
                shadowElevation = 6.dp
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = movie?.images?.firstOrNull()
                    ),

                    contentDescription = "Movie Poster",

                    contentScale = ContentScale.Crop,

                    modifier = Modifier.fillMaxSize()
                )
            }

            // MOVIE INFO
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {

                Text(
                    text = movie?.title ?: "Unknown title",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Director: ${movie?.director ?: "Unknown"}",
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = "Released: ${movie?.year ?: "-"}",
                    style = MaterialTheme.typography.titleSmall
                )

                // EXPANDABLE CONTENT
                AnimatedVisibility(visible = expanded) {

                    Column {

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            buildAnnotatedString {

                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Gray,
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append("Plot: ")
                                }

                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 13.sp
                                    )
                                ) {
                                    append(movie?.plot ?: "")
                                }
                            }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Divider()

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Genre: ${movie?.genre ?: "-"}",
                            style = MaterialTheme.typography.titleSmall
                        )

                        Text(
                            text = "Rating: ${movie?.rating ?: "-"}",
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }

                // EXPAND ICON
                Icon(
                    imageVector =
                        if (expanded)
                            Icons.Filled.KeyboardArrowUp
                        else
                            Icons.Filled.KeyboardArrowDown,

                    contentDescription = "Expand Arrow",

                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            expanded = !expanded
                        },

                    tint = Color.DarkGray
                )
            }
        }
    }
}