package com.example.amphibians.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class AmphibiansCard (
    val id: Int = generateUniqueId(),
    val name: String,
    val type: String,
    val description: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)
fun generateUniqueId(): Int {
    // UUID 생성 또는 임의의 숫자 생성 로직
    return Random.nextInt(1000)
}