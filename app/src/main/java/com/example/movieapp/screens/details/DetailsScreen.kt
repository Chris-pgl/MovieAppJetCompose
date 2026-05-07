package com.example.movieapp.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movie Details")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2196F3)
                )
            )
        }
    ){innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = movieData ?: "No Movie Selected",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))
            /**
             *    navController.popBackStack()
             *    è il metodo corretto per tornare indietro con la navigazione composable.
             */
            Button(onClick = {navController.popBackStack()}) {
                Text("Go Back")
            }
        }
    }

}
