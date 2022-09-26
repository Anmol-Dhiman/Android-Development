package com.example.birthdaycardgdsc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.layout.ContentScale
import com.example.birthdaycardgdsc.ui.theme.BirthdayCardGDSCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardGDSCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage("Android","Anmol")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(name: String,from: String) {
    Column {
        Text(text = "Happy Birthday $name",
        fontSize = 36.sp,
        modifier = Modifier.fillMaxWidth())
        Text(text = "from $from")
    }

}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)
    //Step 3 create a box to overlap image and texts
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(name = message, from = from)
    }
}


@Preview(showBackground = true)
@Composable
fun BirthdayGreetingPreview() {
    BirthdayCardGDSCTheme {
        BirthdayGreetingWithImage("Tirth","Anmol")
    }
}