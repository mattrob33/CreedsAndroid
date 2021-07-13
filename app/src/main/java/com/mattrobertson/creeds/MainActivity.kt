package com.mattrobertson.creeds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mattrobertson.creeds.data.creeds.apostlesCreed
import com.mattrobertson.creeds.data.creeds.niceneCreed
import com.mattrobertson.creeds.model.creed.Creed
import com.mattrobertson.creeds.ui.composables.CreedView
import com.mattrobertson.creeds.ui.theme.CreedsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreedsTheme {
                CreedScreen(apostlesCreed)
            }
        }
    }
}

@Composable
fun CreedScreen(creed: Creed) {
    Surface(color = MaterialTheme.colors.background) {
        CreedView(creed)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CreedsTheme {
        CreedScreen(apostlesCreed)
    }
}