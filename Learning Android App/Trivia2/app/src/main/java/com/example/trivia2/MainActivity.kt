package com.example.trivia2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text

import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trivia2.ui.theme.Trivia2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Trivia2Theme {
                Trivia2()
            }
        }
    }
}

@Composable
fun Trivia2(modifier: Modifier = Modifier) {
    var score by remember { mutableStateOf(0) }
    var choice by remember {
        mutableStateOf("Rock")
    }
    Column() {
        Image(
            painter = painterResource(id = R.drawable.banner_small),
            contentDescription = "banner image"
        )
        Spacer(modifier = Modifier.height(20.dp))
        Score(score.toString(), modifier = modifier)
        Spacer(modifier = Modifier.height(80.dp))
//        here we have to pass the user choice and android choice
        Choice()
        Spacer(modifier = Modifier.height(80.dp))
        Options(choice)
        BottomText(modifier)

    }
}

@Composable
fun Score(score: String = "0", modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxWidth()) {
        Text(
            "Score", style = TextStyle(
                fontSize = 30.sp
            )
        )
        Text(
            "$score/4", style = TextStyle(
                fontSize = 50.sp
            ), modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
fun Choice(yourChoice: String = "Rock", androidChoice: String = "Paper") {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        ChoiceText(choice = yourChoice, whoseChoice = "You chose")
        ChoiceText(choice = androidChoice, whoseChoice = "Android Chose")
    }
}

@Composable
fun ChoiceText(choice: String, whoseChoice: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            whoseChoice, style = TextStyle(
                fontSize = 16.sp
            )
        )
        Text(
            choice, style = TextStyle(
                fontSize = 32.sp, fontWeight = FontWeight.Bold
            ), modifier = Modifier.padding(vertical = 4.dp)
        )
    }

}

@Composable
fun Options(choice: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        ChoiceButton(optionValue = "Rock", choice = choice)
        ChoiceButton(optionValue = "Paper", choice = choice)
        ChoiceButton(optionValue = "Scissors", choice = choice)
    }
}


@Composable
fun ChoiceButton(optionValue: String, choice: String) {
    Button(onClick = { }, shape = RoundedCornerShape(16.dp)) {
        Text(
            text = optionValue,

            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp, end = 8.dp, start = 8.dp),
        )
    }
}

@Composable
fun BottomText(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(

            text = "#JetpackCompose",
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Trivia2()
}