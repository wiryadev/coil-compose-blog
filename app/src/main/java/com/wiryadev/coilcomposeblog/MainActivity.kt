package com.wiryadev.coilcomposeblog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.coil.rememberCoilPainter
import com.wiryadev.coilcomposeblog.ui.theme.CoilComposeBlogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilComposeBlogTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BasicCoilCompose(
                        imgUrl = "https://www.pdvg.it/wp-content/uploads/2021/07/fifa_22.jpg"
                    )
                    // Uncomment below to see the the bug
                    // ImageList()
                }
            }
        }
    }
}

@Composable
fun ImageList() {
    val imgUrl = "https://www.pdvg.it/wp-content/uploads/2021/07/fifa_22.jpg"
    LazyColumn(
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp)
    ) {
        item { AccompanistCoil(imgUrl) }
        item { BasicCoilCompose(imgUrl) }
    }
}

@Composable
fun AccompanistCoil(imgUrl: String) {
    Column {
        Text(text = "Accompanist", style = MaterialTheme.typography.h4)
        Image(
            painter = rememberCoilPainter(imgUrl),
            contentDescription = "Basic",
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun BasicCoilCompose(imgUrl: String) {
    Column {
        Text(text = "Coil", style = MaterialTheme.typography.h4)
        Image(
            painter = rememberImagePainter(imgUrl),
            contentDescription = "Basic",
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoilComposeBlogTheme {
        ImageList()
    }
}