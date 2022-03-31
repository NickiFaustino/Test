package com.example.test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.navigation.MovieNavigation
import com.example.test.screens.home.HomeScreen
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    TestTheme() {
        content()
    }

}
/*
@Composable
fun AccountRow(accountName: String){
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
                Text(text = accountName)
            }

        }


    }
}

 */
/*
@Composable
fun MainContent(accountList: List<String> = listOf("Hello", "Bye", "Hola")){

    LazyColumn{
        items(items = accountList){ name ->
            AccountRow(accountName = name)
        }
    }
// var cnt by remember {
     //   mutableStateOf(0)
   // }
    //var cnt = 0
    /*
    Column() {
        Text(text = "Count: $cnt", style = MaterialTheme.typography.h5)
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Card(modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .height(130.dp)
                .clickable {
                    cnt++
                    Log.d("MainContent", "clicked: $cnt")
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

                    Text(text = "Jane Doe")

                }


            }
        }
    }

     */
}


 */

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        HomeScreen()
    }

}