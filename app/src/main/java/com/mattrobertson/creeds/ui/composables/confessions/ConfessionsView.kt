package com.mattrobertson.creeds.ui.composables.confessions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mattrobertson.creeds.data.confessions.westminsterConfession
import com.mattrobertson.creeds.model.confession.Chapter
import com.mattrobertson.creeds.model.confession.Confession
import com.mattrobertson.creeds.model.confession.Section
import com.mattrobertson.creeds.ui.DisplaySettings
import com.mattrobertson.creeds.ui.theme.AppTheme

@Preview
@Composable
fun ConfessionViewPreview() {
    AppTheme {
        ConfessionView(confession = westminsterConfession)
    }
}

@Composable
fun ConfessionView(
    confession: Confession,
    displaySettings: DisplaySettings = DisplaySettings.Default
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        ConfessionTitle(
            text = confession.title,
            textStyle = displaySettings.titleStyle
        )

        ConfessionTitleSpacer()

        confession.chapters.forEachIndexed { chapterNum, chapter ->
            Chapter(chapterNum + 1, chapter, displaySettings)
            ChapterSpacer()
        }
    }
}

@Composable
fun ConfessionTitle(
    text: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = textStyle
    )
}

@Composable
fun Chapter(
    chapterNum: Int,
    chapter: Chapter,
    displaySettings: DisplaySettings,
    modifier: Modifier = Modifier
) {
    ChapterTitle(
        text = "${chapterNum}. ${chapter.title}",
        textStyle = displaySettings.chapterTitleStyle
    )

    ChapterTitleSpacer()

    chapter.sections.forEachIndexed { sectionNum, section ->
        Section(
            sectionNum = sectionNum + 1,
            section = section,
            textStyle = displaySettings.bodyStyle
        )
        SectionSpacer()
    }
}

@Composable
fun ChapterTitle(
    text: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Left,
        style = textStyle
    )
}

@Composable
fun Section(
    sectionNum: Int,
    section: Section,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    val paragraphStyle = ParagraphStyle(
        textIndent = TextIndent(
            firstLine = 0.sp,
            restLine = 0.sp
        )
    )

    val bodyText = buildAnnotatedString {
        withStyle(paragraphStyle) {
            append("${sectionNum}. ")
            append(section.text)
        }
    }

    Text(
        text = bodyText,
        color = MaterialTheme.colors.onSurface,
        style = textStyle
    )
}

@Composable
fun ConfessionTitleSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun ChapterTitleSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun ChapterSpacer() {
    Spacer(modifier = Modifier.height(32.dp))
}

@Composable
fun SectionSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}