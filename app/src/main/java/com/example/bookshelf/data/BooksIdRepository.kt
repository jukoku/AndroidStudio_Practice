package com.example.bookshelf.data

import com.example.bookshelf.model.BookInit
import com.example.bookshelf.model.Item
import com.example.bookshelf.network.BooksInitApiService

interface BooksIdRepository {
    suspend fun getBooksInitId(): BookInit
}

class NetworkBooksIdRepository(
    private val booksInitApiService: BooksInitApiService
) : BooksIdRepository{
    override suspend fun getBooksInitId(): BookInit
    = booksInitApiService.getBooksId("jazz")
}