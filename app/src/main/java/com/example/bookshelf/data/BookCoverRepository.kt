package com.example.bookshelf.data

import com.example.bookshelf.model.BookCover
import com.example.bookshelf.network.BooksApiService

interface BookCoverRepository {
    suspend fun getBooksCover(id: String) : BookCover
}

class NetworkBooksCoverRepository(
    private val booksApiService: BooksApiService,
) : BookCoverRepository{
    override suspend fun getBooksCover(id: String): BookCover
    = booksApiService.getBooks(id)
}