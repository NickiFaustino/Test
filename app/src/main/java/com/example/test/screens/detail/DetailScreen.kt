package com.example.test.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.test.models.Movie
import com.example.test.models.getMovies
import com.example.test.widgets.HorizontalScrollableImageView
import com.example.test.widgets.MovieRow

@Preview(showBackground = true)
@Composable
fun DetailScreen(navController: NavController = rememberNavController(),
                movieid: String? = "tt0499549"
                 ){
    val movie = filterMovie(movieid = movieid)

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Cyan, elevation = 3.dp) {
                Row {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        })

                    Spacer(modifier = Modifier.width(20.dp))

                    Text(text = movie.title)
                }
            }
        }
    ) {


        MainContent(movie = movie)
    }

}
@Composable
fun MainContent(movie: Movie){

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Column {
            MovieRow(movie = movie)

            Spacer(modifier = Modifier.height(8.dp))

            Divider()

            Text(text = movie.title, style = MaterialTheme.typography.h5)

            HorizontalScrollableImageView(movie = movie)

        }

    }



}

fun filterMovie(movieid: String?): Movie {
    return getMovies().filter { movie -> movie.id == movieid } [0]
}




