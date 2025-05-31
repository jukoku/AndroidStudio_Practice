package com.example.cupcake.test

import androidx.annotation.StringRes
import com.example.cupcake.R
import org.junit.Assert.assertEquals
import org.junit.Test

enum class CupcakeScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Flavor(title = R.string.choose_flavor),
    Pickup(title = R.string.choose_pickup_date),
    Summary(title = R.string.order_summary)
}


