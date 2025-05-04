package com.example.bookshelf.data

import com.example.bookshelf.network.BooksApiService
import com.example.bookshelf.network.BooksInitApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val booksIdRepository: BooksIdRepository
    val booksRepository: BookCoverRepository
}

class DefaultAppContainer(
) : AppContainer {
    private val baseUrl = "https://www.googleapis.com/books/v1/"

    private val jsonConfig = Json{ignoreUnknownKeys = true}
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(jsonConfig.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitInitService: BooksInitApiService by lazy {
        retrofit.create(BooksInitApiService::class.java)
    }
    override val booksIdRepository: BooksIdRepository by lazy {
        NetworkBooksIdRepository(retrofitInitService)
    }

    private val retrofitService: BooksApiService by lazy{
        retrofit.create(BooksApiService::class.java)
    }

    override val booksRepository: BookCoverRepository by lazy{
        NetworkBooksCoverRepository(retrofitService)
    }

}