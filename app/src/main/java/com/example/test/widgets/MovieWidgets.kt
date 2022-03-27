package com.example.test.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.test.models.Movie

@Composable
fun MovieRow(MovieName: String,
             MovieDir: String,
             MovieYear: String,
             MoviePlot: String,
             MovieGenre: String,
             MovieActors: String,
             MovieRate: String){
    var description by remember{
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                elevation = 6.dp){

                Icon(imageVector = Icons.Default.AccountBox, contentDescription ="profile pic" )
            }
            Column() {
                Text(text = MovieName,)
                Text(text = MovieDir)
                Text(text = MovieYear)

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
                            Text(text ="Plot: $MoviePlot")
                            Text(text = "Genre: $MovieGenre")
                            Text(text = "Actors: $MovieActors")
                            Text(text = "Rating: $MovieRate")
                        }
                    }

                }
            }

        }


    }
}