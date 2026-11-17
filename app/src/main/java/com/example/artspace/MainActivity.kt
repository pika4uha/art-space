package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

data class Artwork(
    @DrawableRes val image: Int,
    val title: String,
    val artist: String,
    val year: String
)

val artworks = listOf(
    Artwork(R.drawable.art_1, "Райан Гослинг", "Художник 1", "2001"),
    Artwork(R.drawable.art_2, "Ремонт бытовой техники", "Художник 2", "2005"),
    Artwork(R.drawable.art_3, "Арт в стиле Симпсонов", "Художник 3", "2010")
)

fun nextIndex(current: Int, size: Int): Int = (current + 1) % size
fun previousIndex(current: Int, size: Int): Int = (current - 1 + size) % size

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var index by remember { mutableIntStateOf(0) }
    val art = artworks[index]

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shadowElevation = 8.dp,
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(art.image),
                contentDescription = art.title,
                modifier = Modifier.padding(24.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFECEBF4))
                .padding(16.dp)
        ) {
            Text(text = art.title, fontSize = 28.sp)
            Text(text = "${art.artist} (${art.year})")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { index = previousIndex(index, artworks.size) },
                modifier = Modifier.width(130.dp)
            ) { Text("Previous") }
            Button(
                onClick = { index = nextIndex(index, artworks.size) },
                modifier = Modifier.width(130.dp)
            ) { Text("Next") }
        }
    }
}