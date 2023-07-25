package com.example.dailyjourney.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.dailyjourney.R

val AbrilFatFace = FontFamily(Font(R.font.abrilfatface_regular))
val Oswald = FontFamily(
    Font(R.font.oswald_semibold, FontWeight.SemiBold),
    Font(R.font.oswald_regular, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = AbrilFatFace
    ),
    displayMedium = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = Oswald
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Oswald
    )
)