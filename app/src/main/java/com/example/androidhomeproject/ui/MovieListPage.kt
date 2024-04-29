package com.example.androidhomeproject.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidhomeproject.R
import com.example.androidhomeproject.ui.state.Movie
import com.example.androidhomeproject.ui.theme.AndroidHomeProjectTheme

@Composable
fun MovieList(navHostController: NavHostController) {

    val viewModel = MovieListViewModel()
    val movieList = viewModel.movieList

    AndroidHomeProjectTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(items = movieList) { _, item ->
                    MovieItem(navHostController, item)
                }
            }
        }
    }
}

@Composable
fun MovieItem(navHostController: NavHostController, movie: Movie) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize()
            .clickable {
                navHostController.currentBackStackEntry?.savedStateHandle?.set(
                    "data",
                    movie
                )
                navHostController.navigate(Screen.MovieDetail.route)
            }
            .border(
                BorderStroke(
                    width = 2.dp,
                    color = Color.Gray
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            // Hard code an icon drawable as the image
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = movie.title,
            alignment = Alignment.TopCenter
        )
        Text(
            text = movie.title,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}
