package com.example.androidhomeproject.network.service

import com.example.androidhomeproject.model.MovieListContainer
import com.example.androidhomeproject.ui.state.Movie
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class MovieListServiceImpl : MovieListService {

    // This is just a simple client, for the real world, we will need to have different configurations
    // based on if user is logged or not, if the content needs auth and so on.
    private val httpClient = HttpClient()

    override suspend fun getMovieList(): MovieListContainer {

        try {
            // Simulate a simple http GET request to fetch data from server
            val data = httpClient.get<MovieListContainer>("https://our.url.com")
        } catch (e: Exception) {
            // Handle exception, and save this error because the view will need it.
        }

        // Hard code the result for this project
        val result = mutableListOf<Movie>()
        for (i in 1..100) {
            result.add(
                Movie(
                    i,
                    "Image placeholder $i",
                    "Test tile $i",
                    "Test description $i xxxxxxxxxxxxxx"
                )
            )
        }
        return MovieListContainer(result)
    }
}
