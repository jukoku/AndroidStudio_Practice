package com.example.dessertclicker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    displaySmall = TextStyle(
        color = Color(0xFF008577),
        fontSize = 33.sp
    ),
    bodyMedium = TextStyle(
        color = Color(0x99000000),
        fontSize = 20.sp
    )
)