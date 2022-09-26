package com.example.tipcalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.tipcalc.ui.theme.TipCalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalcTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    var amountInput by remember { mutableStateOf("") }
    TextField(
        value = amountInput,
        label = {
            Text(text = "Enter the tip amount")
        },
        onValueChange = { amountInput = it },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions =
        KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )

    TextField(
        value = amountInput,
        label = {
            Text(text = "Enter the tip amount")
        },
        onValueChange = { amountInput = it },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions =
        KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalcTheme {
        Greeting()
    }
}