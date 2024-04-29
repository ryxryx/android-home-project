package com.example.androidhomeproject.network.service

import com.example.androidhomeproject.model.MovieListContainer
import com.example.androidhomeproject.ui.state.Movie
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class MovieListServiceImpl : MovieListService {

    private val httpClient = HttpClient()

    override suspend fun getMovieList(): MovieListContainer {

        try {
            // Simulate a simple http GET request to fetch data from server
            val data = httpClient.get<MovieListContainer>("https://our.url.com")
        } catch (e: Exception) {
            // Handle exception
        }

        // hard code the result for this project
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
