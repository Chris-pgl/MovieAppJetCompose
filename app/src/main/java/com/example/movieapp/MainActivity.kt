package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding)) {
                        Text("Contenuto della Movie App")
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier, 
    content: @Composable () -> Unit
){
    content()
}

@Composable
fun MainContent(){
    Scaffold(containerColor = MaterialTheme.colorScheme.background) {
        innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Text("MainContent")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MyAppPreview() {
    MyApp() {
        Text("Contenuto della Movie AppPre")
    }
}
