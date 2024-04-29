package com.example.androidhomeproject.model

import com.example.androidhomeproject.ui.state.Movie

// Container return fro the api response
data class MovieListContainer(
    val items: List<Movie>
)
