package com.example.woof.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.woof.R

val AbrilFatface = FontFamily(
    Font(R.font.abril_fatface_regular)
)

val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = AbrilFatface,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    displaySmall = TextStyle(fontFamily = Montserrat),
    headlineLarge = TextStyle(fontFamily = Montserrat),
    headlineMedium = TextStyle(fontFamily = Montserrat),
    headlineSmall = TextStyle(fontFamily = Montserrat),
    titleLarge = TextStyle(fontFamily = Montserrat),
    titleMedium = TextStyle(fontFamily = Montserrat),
    titleSmall = TextStyle(fontFamily = Montserrat),
    bodyLarge = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(fontFamily = Montserrat),
    bodySmall = TextStyle(fontFamily = Montserrat),
    labelLarge = TextStyle(fontFamily = Montserrat),
    labelMedium = TextStyle(fontFamily = Montserrat),
    labelSmall = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
)

