package com.example.amphibians.fake

import com.example.amphibians.model.AmphibiansCard

object FakeDataSource {

    private const val idOne: Int = 1
    private const val idTwo: Int = 2
    private const val nameOne = "name.one"
    private const val nameTwo = "name.two"
    private const val imgOne = "url.one"
    private const val imgTwo = "url.two"
    private const val typeOne = "type.one"
    private const val typeTwo = "type.two"
    private const val desOne = "des.one"
    private const val desTwo = "des.two"
    val cardsList = listOf(
        AmphibiansCard(
            id = idOne,
            name = nameOne,
            imgSrc = imgOne,
            type = typeOne,
            description = desOne
        ),
        AmphibiansCard(
            id = idTwo,
            name = nameTwo,
            imgSrc = imgTwo,
            type = typeTwo,
            description = desTwo
        )
    )
}
