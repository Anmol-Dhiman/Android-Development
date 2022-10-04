package com.example.trivia3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trivia3.datac.Restaurant
import com.example.trivia3.datasource.datasource
import com.example.trivia3.ui.theme.Trivia3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Trivia3Theme {
                MainApp()
            }
        }
    }
}


@Composable
fun MainApp() {
    RestaurantList(restaurantsList = datasource().restaurantsData(), modifier = Modifier)
}

@Composable
fun Restaurantcard(restau: Restaurant, modifier: Modifier) {
    Card(modifier = Modifier.padding(8.dp), elevation = 10.dp, shape = RoundedCornerShape(15.dp)) {


        Column() {
            Image(
                painter = painterResource(id = restau.imageResourceId),
                contentDescription = stringResource(
                    id = restau.stringResourceId
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(192.dp),
                contentScale = ContentScale.Crop
            )
            Row {
                Column(modifier = Modifier.padding(vertical = 5.dp)) {
                    Text(
                        text = stringResource(id = restau.stringResourceId),
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = MaterialTheme.typography.h6
                    )

                    Text(
                        text = stringResource(id = restau.string2ResourceId),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Column() {
                    Row(
                        modifier = Modifier
                            .padding(top = 5.dp, start = 50.dp)
                            .background(color = Color.Cyan, shape = RoundedCornerShape(5.dp))
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color.Yellow,
                            modifier = Modifier.padding(start = 0.dp)
                        )
                        Text(text = stringResource(id = restau.string3ResourceId) + "  ")

                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "₹" + restau.price.toString() + " for one",
                        modifier = Modifier.padding(start = 50.dp)
                    )

                }
            }
        }
    }
}

@Composable
fun icon() {
    Icon(imageVector = Icons.Default.Search, contentDescription = null)
}

@Composable
private fun RestaurantList(restaurantsList: List<Restaurant>, modifier: Modifier) {
    Column {
        var values by remember {
            mutableStateOf("Restaurant name or a dish")
        }

        TextField(
            value = "",
            label = { Text(text = values) },
            onValueChange = { newValue -> values = newValue },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 8.dp),
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                cursorColor = Color.Black,
                leadingIconColor = Color.White,
                trailingIconColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ), leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp),
                    tint = Color.Black
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(restaurantsList) { restaurant ->
                Restaurantcard(restau = restaurant, modifier = modifier)
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainApp()
}