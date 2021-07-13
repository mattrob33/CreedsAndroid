package com.mattrobertson.creeds.ui.composables

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mattrobertson.creeds.data.creeds.niceneCreed
import com.mattrobertson.creeds.model.creed.Creed
import com.mattrobertson.creeds.ui.DisplaySettings

@Composable
fun CreedView(
    creed: Creed,
    displaySettings: DisplaySettings = DisplaySettings.DEFAULT
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
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
    val paragraphStyle = ParagraphStyle(
        textIndent = TextIndent(
            firstLine = 0.sp,
            restLine = displaySettings.bodyFontSize * 1.25
        )
    )

    val bodyText = buildAnnotatedString {
        withStyle(paragraphStyle) {
            append(text)
        }
    }

    Text(
        text = bodyText,
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
        creed = niceneCreed
    )
}