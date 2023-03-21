package com.example.compose_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose_navigation.ui.theme.Compose_navigationTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var nav: NavHostController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            Compose_navigationTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android", Modifier, nav)
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier,
    nav: NavHostController
) {


    Surface(modifier = modifier.fillMaxSize()) {
        Text(text = "Hello $name! greeting")
        Spacer(modifier = modifier.width(10.dp))
        Button(onClick = { nav.navigate("other") }) {

        }
    }
}

@Composable
fun other(name: String, modifier: Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Text(text = "Hello $name! other")
    }
}

