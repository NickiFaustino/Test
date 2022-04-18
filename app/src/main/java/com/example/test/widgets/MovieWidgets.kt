package com.example.test.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.test.models.Movie
import com.example.test.models.getMovies
import com.example.test.screens.detail.filterMovie
import com.example.test.viewmodels.MovieViewModels

@Composable
fun MovieRow(movie: Movie = getMovies()[0],
             onItemClick: (String) -> Unit = {},
             onSaveClick: (Movie) -> Unit ={}
){
    var description by remember{
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
            onItemClick(movie.id)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp) {

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                elevation = 6.dp){

                //Icon(imageVector = Icons.Default.AccountBox, contentDescription ="profile pic" )
                Image(
                    painter = rememberImagePainter(
                        data = movie.images[0],
                        builder = {
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = "Movie Poster" )
            }
            Column() {
                Text(text = movie.title,)
                Text(text = movie.director)
                Text(text = movie.year)

                //could have done another composable named AnimatedVisibility
                IconButton(onClick = { description = !description}) {
                    if (!description) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Description",
                        )
                    } else{
                        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Close")
                    }
                }
                DropdownMenu(expanded = description, onDismissRequest = {description = false}) {
                    DropdownMenuItem(onClick = { description = !description }) {
                        Column{
                            Text(text ="Plot: ${movie.plot}")
                            Text(text = "Genre: ${movie.genre}")
                            Text(text = "Actors: ${movie.actors}")
                            Text(text = "Rating: ${movie.rating}")
                        }
                    }

                }
            }

            FavoriteIcon(){

            }

        }


    }
}

@Composable
fun FavoriteIcon(
    movie: Movie = getMovies()[0],
    onSaveClick: (Movie) -> Unit
){
    var fav by remember{
        mutableStateOf(false)
    }
    IconButton(onClick = { onSaveClick(movie); fav = !fav}) {
        if (!fav) {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Unfavorite")
        }
        else{
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
        }
    }
}

@Composable
fun HorizontalScrollableImageView(movie: Movie = getMovies()[0]){
    LazyRow{
        items(movie.images){ image ->
            Card(modifier = Modifier
                .padding(12.dp)
                .size(240.dp)){
                Image(painter = rememberImagePainter(data = image),
                    contentDescription = "Movie image")
            }


        }
    }
}