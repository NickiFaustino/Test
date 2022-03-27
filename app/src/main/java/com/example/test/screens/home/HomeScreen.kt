package com.example.test.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.test.models.Movie
import com.example.test.models.getMovies
import com.example.test.widgets.MovieRow

@Composable
fun HomeScreen(){
    MainContent(getMovies())
}


@Composable
fun MainContent(movieList: List<Movie>) {

    LazyColumn {
        items(items = movieList) { text ->
            MovieRow(MovieName = text.title,
                MovieDir = text.director,
                MovieYear = text.year,
                MoviePlot = text.plot,
                MovieGenre = text.genre,
                MovieActors = text.actors,
                MovieRate = text.rating)

        }

    }
}

