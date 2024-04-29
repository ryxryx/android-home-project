package com.example.androidhomeproject.network.service

import com.example.androidhomeproject.model.MovieListContainer

interface MovieListService {

    suspend fun getMovieList(): MovieListContainer
}
