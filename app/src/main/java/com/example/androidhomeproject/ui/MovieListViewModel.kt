package com.example.androidhomeproject.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomeproject.network.repository.MovieListRepository
import com.example.androidhomeproject.network.repository.MovieListRepositoryImpl
import com.example.androidhomeproject.ui.state.Movie
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {

    var movieList = mutableStateListOf<Movie>()
        private set

    private val repository: MovieListRepository = MovieListRepositoryImpl()

    init {
        loadMovieList()
    }

    private fun loadMovieList() {
        viewModelScope.launch {
            // I would want to support pagination if this is a requirement.
            // I would hope the api call take a page number, and we can make continuous calls as
            // user scroll down and down. We append more data into "movieList".
            val result = repository.getMovieList()
            // Needs to have some error handling
            if (result.items.isNotEmpty()) {
                result.items.forEach {
                    movieList.add(it)
                }
            }
        }
    }
}
