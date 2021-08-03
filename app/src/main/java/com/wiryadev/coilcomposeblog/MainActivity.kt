package com.wiryadev.coilcomposeblog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import coil.transform.RoundedCornersTransformation
import com.wiryadev.coilcomposeblog.ui.theme.CoilComposeBlogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilComposeBlogTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ImageList()
                }
            }
        }
    }
}

@Composable
fun ImageList() {
    val imgUrl =
        "https://images.unsplash.com/photo-1574158622682-e40e69881006?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80"

    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item { BasicCoil(imgUrl) }
        item { FixedSizePixel(imgUrl) }
        item { BasicCoilWithOriginalSize(imgUrl) }
        item { RoundedCornerTransformation(imgUrl) }
        item { RoundedCornerManual(imgUrl) }
        item { CrossFadeCoil(imgUrl) }
    }
}

@Composable
fun BasicCoil(imgUrl: String) {
    Column {
        Text(text = "Fixed Size", style = MaterialTheme.typography.h5)
        Image(
            painter = rememberImagePainter(data = imgUrl),
            contentDescription = "Fixed Size",
            modifier = Modifier.size(128.dp),
        )
    }
}

@Composable
fun BasicCoilWithOriginalSize(imgUrl: String) {
    Column {
        Text(text = "Original Size", style = MaterialTheme.typography.h5)
        Image(
            painter = rememberImagePainter(
                data = imgUrl,
                builder = {
                    size(OriginalSize)
                }
            ),
            contentDescription = "Original Size",
        )
    }
}

@Composable
fun FixedSizePixel(imgUrl: String) {
    Column {
        Text(text = "Pixel Size", style = MaterialTheme.typography.h5)
        Image(
            painter = rememberImagePainter(
                data = imgUrl,
                builder = {
                    size(256)
                }
            ),
            contentDescription = "Pixel Size",
        )
    }
}

@Composable
fun RoundedCornerTransformation(imgUrl: String) {
    Column {
        Text(text = "Coil Transformation", style = MaterialTheme.typography.h5)
        Image(
            painter = rememberImagePainter(
                data = imgUrl,
                builder = {
                    // menggunakan float untuk pixelnya
                    transformations(RoundedCornersTransformation(24f))
                }
            ),
            contentDescription = "Coil Transformation",
            modifier = Modifier.size(128.dp)
        )
    }
}

@Composable
fun RoundedCornerManual(imgUrl: String) {
    Column {
        Text(text = "Dp Transformation", style = MaterialTheme.typography.h5)
        Image(
            painter = rememberImagePainter(
                data = imgUrl,
            ),
            contentDescription = "Dp Transformation",
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(24.dp))
        )
    }
}


@Composable
fun CrossFadeCoil(imgUrl: String) {
    Column {
        Text(text = "Coil Crossfade", style = MaterialTheme.typography.h5)
        Image(
            painter = rememberImagePainter(
                data = imgUrl,
                builder = {
                    // umumnya cukup seperti ini
                    // crossfade(true)
                    // tapi agar efeknya bisa dilihat, set durasinya jadi cukup lama
                    crossfade(20000)
                }
            ),
            contentDescription = "Coil Crossfade",
            modifier = Modifier.size(128.dp)
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