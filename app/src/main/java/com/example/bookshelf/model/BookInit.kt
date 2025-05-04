package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BookInit (
    @SerialName("items")
    val items: List<Item>
)

@Serializable
data class Item(
    @SerialName("id")
    val id: String
)