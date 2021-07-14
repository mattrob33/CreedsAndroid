package com.mattrobertson.creeds.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

data class DisplaySettings(
    val titleStyle: TextStyle,
    val chapterTitleStyle: TextStyle,
    val catechismQuestionStyle: TextStyle,
    val bodyStyle: TextStyle
) {
    companion object {
        val Default: DisplaySettings
            @Composable
            get() = DisplaySettings(
                    titleStyle = MaterialTheme.typography.h1,
                    chapterTitleStyle = MaterialTheme.typography.h3,
                    catechismQuestionStyle = MaterialTheme.typography.h3,
                    bodyStyle = MaterialTheme.typography.body1
                )
    }
}
