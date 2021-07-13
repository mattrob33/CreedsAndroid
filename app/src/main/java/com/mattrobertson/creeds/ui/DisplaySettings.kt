package com.mattrobertson.creeds.ui

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class DisplaySettings(
    var titleFontSize: TextUnit,
    var titleFont: FontFamily,
    var titleFontWeight: FontWeight,
    var titleLineHeightMultiplier: Float,

    var bodyFontSize: TextUnit,
    var bodyFont: FontFamily,
    var bodyFontWeight: FontWeight,
    var bodyLineHeightMultiplier: Float
) {
    companion object {
        val DEFAULT: DisplaySettings
            get() = DisplaySettings(
                titleFontSize = 20.sp,
                titleFont = FontFamily.Serif,
                titleFontWeight = FontWeight.W500,
                titleLineHeightMultiplier = 1f,

                bodyFontSize = 14.sp,
                bodyFont = FontFamily.Serif,
                bodyFontWeight = FontWeight.W400,
                bodyLineHeightMultiplier = 1.25f
            )
    }
}
