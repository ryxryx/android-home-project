package com.example.androidhomeproject.network.repository

import com.example.androidhomeproject.model.MovieListContainer

interface MovieListRepository {
    suspend fun getMovieList() : MovieListContainer
}
