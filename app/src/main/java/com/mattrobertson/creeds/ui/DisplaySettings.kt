package com.mattrobertson.creeds.ui

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.mattrobertson.creeds.ui.fonts.merriweather
import com.mattrobertson.creeds.ui.fonts.trirong

data class DisplaySettings(
    var titleFontSize: TextUnit,
    var titleFont: FontFamily,
    var titleFontWeight: FontWeight,
    var titleLineHeightMultiplier: Float,

    var subtitleFontSize: TextUnit,
    var subtitleFont: FontFamily,
    var subtitleFontWeight: FontWeight,
    var subtitleLineHeightMultiplier: Float,

    var bodyFontSize: TextUnit,
    var bodyFont: FontFamily,
    var bodyFontWeight: FontWeight,
    var bodyLineHeightMultiplier: Float
) {
    companion object {
        val DEFAULT: DisplaySettings
            get() = DisplaySettings(
                titleFontSize = 24.sp,
                titleFont = trirong,
                titleFontWeight = FontWeight.SemiBold,
                titleLineHeightMultiplier = 1f,

                subtitleFontSize = 20.sp,
                subtitleFont = trirong,
                subtitleFontWeight = FontWeight.SemiBold,
                subtitleLineHeightMultiplier = 1f,

                bodyFontSize = 18.sp,
                bodyFont = merriweather,
                bodyFontWeight = FontWeight.Light,
                bodyLineHeightMultiplier = 1.4f
            )
    }
}
