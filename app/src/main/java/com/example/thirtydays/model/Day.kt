package com.example.thirtydays.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day (
    @StringRes val day: Int,
    @StringRes val title: Int,
    @DrawableRes val img: Int,
    @StringRes val description: Int
)