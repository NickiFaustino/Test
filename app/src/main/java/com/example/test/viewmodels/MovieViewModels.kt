package com.example.test.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.test.models.Movie

class MovieViewModels : ViewModel() {
    private var fave = mutableStateListOf<Movie>()

    fun addfave(movie: Movie) {
        fave.add(movie)
    }

    fun removefave(movie: Movie) {
        fave.remove(movie)
    }

    fun getallfave(): List<Movie>{
        return fave
    }
}