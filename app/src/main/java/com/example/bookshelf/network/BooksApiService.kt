package com.example.bookshelf.network

import com.example.bookshelf.model.BookCover
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApiService {
    @GET("volumes/{id}")
    suspend fun getBooks(
        @Path(value = "id") id : String
    ): BookCover
}