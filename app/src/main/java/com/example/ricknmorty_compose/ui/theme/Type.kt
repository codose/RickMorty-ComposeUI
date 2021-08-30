package com.example.ricknmorty_compose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ricknmorty_compose.R

// Set of Material typography styles to start with
val Typography by lazy {
    Typography(
        body1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ),
        body2 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        h2 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        ),
        button = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        ),
        caption = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        ),
        defaultFontFamily = fonts
    )
}

val fonts = FontFamily(
    Font(R.font.proxima_regular),
    Font(R.font.proxima_bold, weight = FontWeight.Bold),
    Font(R.font.proxima_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.proxima_thin, weight = FontWeight.Thin)
)