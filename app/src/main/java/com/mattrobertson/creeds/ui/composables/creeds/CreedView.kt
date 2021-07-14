package com.mattrobertson.creeds.ui.composables.creeds

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.mattrobertson.creeds.data.creeds.apostlesCreed
import com.mattrobertson.creeds.model.creed.Creed
import com.mattrobertson.creeds.ui.CreedTab
import com.mattrobertson.creeds.ui.DisplaySettings
import com.mattrobertson.creeds.ui.theme.CreedsTheme
import kotlinx.coroutines.launch

@Preview
@Composable
fun CreedViewPreview() {
    CreedsTheme {
        CreedView(creed = apostlesCreed)
    }
}

@Composable
fun CreedView(
    creed: Creed,
    displaySettings: DisplaySettings = DisplaySettings.DEFAULT
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
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
        color = MaterialTheme.colors.onSurface,
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
        color = MaterialTheme.colors.onSurface,
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