package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BookCover (
    @SerialName("id")
    val id: String,
    @SerialName("volumeInfo")
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    @SerialName("title")
    val title: String,
    @SerialName("authors")
    val authors: List<String> ?= emptyList(),
    @SerialName("description")
    val description: String ?= "No description",
    @SerialName("imageLinks")
    val imageLinks: ImageLinks
)

@Serializable
data class ImageLinks(
    @SerialName("small")
    val small: String,
    @SerialName("medium")
    val medium: String ?= small,
    @SerialName("large")
    val large: String ?= medium,
    @SerialName("extraLarge")
    val imgSrc: String ?= large
)