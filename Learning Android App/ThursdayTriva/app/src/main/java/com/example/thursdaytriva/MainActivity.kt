package com.example.thursdaytriva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.foundation.Image

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thursdaytriva.ui.theme.ThursdayTrivaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThursdayTrivia(name = "Anmol")
        }
    }
}

@Composable
fun ThursdayTrivia(name: String) {
    Scaffold(
        backgroundColor = Color.White,
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),

                verticalArrangement = Arrangement.Center
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.jetpack_compose_icon),
                    contentDescription = "Jetpack Icon",
                    modifier = Modifier.height(200.dp)
                )

                TextWidget(
                    name,
                    clr = Color(56, 112, 179, 255),
                )
                TextWidget(txt = "❤", clr = Color.Red)
                TextWidget(txt = "Jetpack Compose", clr = Color(8, 48, 66, 255))
            }
        }
    )
}

@Composable
fun TextWidget(txt: String, clr: Color) {
    Text(
        txt,
        style = TextStyle(
            color = clr,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold
        ),
        modifier = Modifier.padding(vertical = 8.dp)
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThursdayTrivaTheme {
        ThursdayTrivia(name = "Anmol")
    }
}