package com.example.androidhomeproject.network.repository

import com.example.androidhomeproject.model.MovieListContainer
import com.example.androidhomeproject.network.service.MovieListServiceImpl

class MovieListRepositoryImpl : MovieListRepository {

    private val movieListService = MovieListServiceImpl()

    override suspend fun getMovieList(): MovieListContainer {
        return movieListService.getMovieList()
    }
}
