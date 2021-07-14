package com.mattrobertson.creeds.ui.fonts

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.mattrobertson.creeds.R

val merriweather = FontFamily(
    Font(R.font.merriweather_light, FontWeight.Light),
    Font(R.font.merriweather_regular, FontWeight.Normal),
    Font(R.font.merriweather_bold, FontWeight.Bold),
    Font(R.font.merriweather_black, FontWeight.Black)
)

val trirong = FontFamily(
    Font(R.font.trirong_thin, FontWeight.Thin),
    Font(R.font.trirong_regular, FontWeight.Normal),
    Font(R.font.trirong_medium, FontWeight.Medium),
    Font(R.font.trirong_semibold, FontWeight.SemiBold),
    Font(R.font.trirong_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.trirong_bold, FontWeight.Bold)
)