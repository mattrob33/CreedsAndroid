package com.mattrobertson.creeds.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mattrobertson.creeds.ui.fonts.merriweather
import com.mattrobertson.creeds.ui.fonts.trirong

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = trirong,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontFamily = trirong,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Italic,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = trirong,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Italic,
        fontSize = 18.sp,
        lineHeight = 18.sp * 1.25
    ),
    body1 = TextStyle(
        fontFamily = merriweather,
        fontWeight = FontWeight.Light,
        fontSize = 18.sp,
        lineHeight = 18.sp * 1.4
    )
)