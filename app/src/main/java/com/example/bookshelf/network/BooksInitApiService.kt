package com.example.bookshelf.network

import com.example.bookshelf.model.BookInit
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksInitApiService {
    @GET("volumes")
    suspend fun getBooksId(
        @Query("q") search: String ?= "jazz"
    ): BookInit
}