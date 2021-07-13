package com.mattrobertson.creeds.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mattrobertson.creeds.data.creeds.apostlesCreed
import com.mattrobertson.creeds.data.creeds.chalcedonianCreed
import com.mattrobertson.creeds.data.creeds.niceneCreed
import com.mattrobertson.creeds.model.creed.Creed
import com.mattrobertson.creeds.ui.DisplaySettings

@Composable
fun CreedView(
    creed: Creed,
    displaySettings: DisplaySettings = DisplaySettings.DEFAULT
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Title(
            text = creed.title,
            displaySettings = displaySettings
        )

        TitleSpacer()

        BodyText(
            text = creed.text,
            displaySettings = displaySettings
        )
    }
}

@Composable
fun Title(
    text: String,
    displaySettings: DisplaySettings = DisplaySettings.DEFAULT,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = displaySettings.titleFontSize,
        fontFamily = displaySettings.titleFont,
        fontWeight = displaySettings.titleFontWeight,
        lineHeight = displaySettings.titleFontSize * displaySettings.titleLineHeightMultiplier
    )
}

@Composable
fun BodyText(
    text: String,
    displaySettings: DisplaySettings = DisplaySettings.DEFAULT,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = displaySettings.bodyFontSize,
        fontFamily = displaySettings.bodyFont,
        fontWeight = displaySettings.bodyFontWeight,
        lineHeight = displaySettings.bodyFontSize * displaySettings.bodyLineHeightMultiplier
    )
}

@Composable
fun TitleSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Preview
@Composable
fun Preview() {
    CreedView(
        creed = apostlesCreed
    )
}