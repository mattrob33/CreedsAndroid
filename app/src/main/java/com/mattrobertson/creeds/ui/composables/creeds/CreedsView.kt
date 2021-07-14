package com.mattrobertson.creeds.ui.composables.creeds

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
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
import com.mattrobertson.creeds.data.creeds.apostlesCreed
import com.mattrobertson.creeds.model.creed.Creed
import com.mattrobertson.creeds.ui.theme.AppTheme

@Preview
@Composable
fun CreedViewPreview() {
    AppTheme {
        CreedView(creed = apostlesCreed)
    }
}

@Composable
fun CreedView(creed: Creed) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Title(creed.title)
        TitleSpacer()
        BodyText(creed.text)
    }
}

@Composable
fun Title(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h1
    )
}

@Composable
fun BodyText(
    text: String,
    modifier: Modifier = Modifier
) {
    val paragraphStyle = ParagraphStyle(
        textIndent = TextIndent(
            firstLine = 0.sp,
            restLine = MaterialTheme.typography.body1.fontSize * 1.25
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
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun TitleSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}