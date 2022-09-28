package com.example.unit3list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
 import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unit3list.ui.theme.Unit3ListTheme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
 import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit3ListTheme {

                AffirmationApp()
            }
        }
    }
}

@Composable
fun AffirmationApp() {
    AffirmationList(affirmationList = loadAffirmations())
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(affirmationList) { affirmation ->
            AffirmationCard(affirmation)
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Preview
@Composable
private fun AffirmationCardPreview() {
    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
}


fun loadAffirmations(): List<Affirmation> {
    return listOf<Affirmation>(
        Affirmation(R.string.affirmation1, R.drawable.image1),
        Affirmation(R.string.affirmation2, R.drawable.image2),
        Affirmation(R.string.affirmation3, R.drawable.image3),
        Affirmation(R.string.affirmation4, R.drawable.image4),
        Affirmation(R.string.affirmation5, R.drawable.image5),
        Affirmation(R.string.affirmation6, R.drawable.image6),
        Affirmation(R.string.affirmation7, R.drawable.image7),
        Affirmation(R.string.affirmation8, R.drawable.image8),
        Affirmation(R.string.affirmation9, R.drawable.image9),
        Affirmation(R.string.affirmation10, R.drawable.image10)
    )
}