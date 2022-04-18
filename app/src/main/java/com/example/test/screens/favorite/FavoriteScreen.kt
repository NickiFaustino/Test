package com.example.test.screens.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.test.models.Movie
import com.example.test.models.getMovies
import com.example.test.viewmodels.MovieViewModels
import com.example.test.widgets.FavoriteIcon
import com.example.test.widgets.MovieRow

@Composable
fun FavoriteScreen(navController: NavController, movie: Movie = getMovies()[0], viewModel: MovieViewModels = viewModel()){

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Cyan, elevation = 3.dp) {
                Row {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        })

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(text = "My Favorite Movies")
                }
            }
        }
    ) {

        MainContent()
    }
}
@Composable
fun MainContent(viewModel: MovieViewModels = viewModel(),){

    FavoriteIcon { movie ->
        viewModel.addfave(movie)
    }
    LazyColumn{
        items(items = viewModel.getallfave()) { movie ->
            MovieRow(movie = movie)
        }
    }

}

