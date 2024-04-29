package com.example.androidhomeproject.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidhomeproject.R
import com.example.androidhomeproject.ui.state.Movie
import com.example.androidhomeproject.ui.theme.AndroidHomeProjectTheme

@Composable
fun MovieDetail(navHostController: NavHostController) {

    val movie = navHostController.previousBackStackEntry?.savedStateHandle?.get<Movie>("data")

    AndroidHomeProjectTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // TODO: To replace the image with a video player, I would create a player view from
                // ExoPlayer and hook up with player. And I will put the player view underneath the
                // Thumbnail.
                // But I have to search and reference the ExoPlayer documentation and code samples
                // for the implementation details.
                Image(
                    // Use a icon drawable as the image
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = movie?.title,
                    alignment = Alignment.TopCenter
                )
                Text(
                    text = movie?.title ?: "",
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )
                Text(
                    text = movie?.description ?: "",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
    }
}
