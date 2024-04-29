package com.example.androidhomeproject.model

import com.example.androidhomeproject.ui.state.Movie

// Container return fro the api response
// Need to consider also include the error information if the api call fails. And this error information
// will be passed to the view, and for logic to happen there, such as, error page, retry, and exiting the app, etc.
data class MovieListContainer(
    val items: List<Movie>
)
