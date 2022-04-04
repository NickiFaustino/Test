package com.example.test.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.test.models.Movie
import com.example.test.models.getMovies
import com.example.test.navigation.MovieScreens
import com.example.test.ui.theme.TestTheme
import com.example.test.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController = rememberNavController(),
               onItemClick: (String) -> Unit = {}){
    var showMenu by remember{
        mutableStateOf(false)
    }
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "HomeScreen") },
                    actions = {
                        IconButton(onClick = { showMenu = !showMenu}) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                        }
                        DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false}) {
                            DropdownMenuItem(onClick = {  }) {
                                Row{
                                    IconButton(onClick = { navController.navigate(route = MovieScreens.FavoriteScreen.name) }) {
                                        Icon(imageVector = Icons.Default.Favorite,
                                            contentDescription = "Favorites",
                                            modifier = Modifier
                                                .padding(4.dp))
                                    }
                                }

                            }
                        }
                    }
                )
            }
        ) {



            MainContent(navController = navController, getMovies())
        }

}


@Composable
fun MainContent(navController: NavController, movies: List<Movie> = getMovies()) {

    LazyColumn {
        items(items = movies) { movie ->
            MovieRow(movie = movie){ movieId ->
                navController.navigate(route = MovieScreens.DetailScreen.name + "/$movieId")
            }

        }

    }
}

