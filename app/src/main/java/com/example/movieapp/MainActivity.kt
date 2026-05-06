package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieAppTheme {
                    MyApp{
                        MainContent()
                    }
                }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(
    modifier: Modifier = Modifier, 
    content: @Composable () -> Unit
){
    MovieAppTheme{
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Movie App")},
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF2196F3)
                    )
                )
            }
        ){innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding)
            ){
                content()
            }
        }
    }
}

@Composable
fun MainContent(
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Life",
        "Matrix",
        "Inception"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(movieList) { movie ->
                Text(text = movie)
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun MyAppPreview() {
    MyApp() {
        MainContent()
    }
}
