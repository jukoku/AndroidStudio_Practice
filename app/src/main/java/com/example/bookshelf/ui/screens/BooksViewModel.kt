package com.example.bookshelf.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.bookshelf.BooksApplication
import com.example.bookshelf.data.BookCoverRepository
import com.example.bookshelf.data.BooksIdRepository
import com.example.bookshelf.model.BookCover
import com.example.bookshelf.model.VolumeInfo
import kotlinx.coroutines.launch
import okio.IOException

sealed interface BooksUiState{
    data class Success(val covers: List<BookCover>) : BooksUiState
    data object Error : BooksUiState
    data object Loading : BooksUiState
}

class BooksViewModel (
    private val booksIdRepository: BooksIdRepository,
    private val bookCoverRepository: BookCoverRepository
) : ViewModel() {
    var booksUiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        getBooksShelf()
    }

    fun getBooksShelf(){
        viewModelScope.launch {
            booksUiState = BooksUiState.Loading
            booksUiState = try {
                val bookInit = booksIdRepository.getBooksInitId()
                val covers: MutableList<BookCover> = mutableListOf()
                for (id in bookInit.items){
                    covers.add(bookCoverRepository.getBooksCover(id.id))
                }
                BooksUiState.Success(covers)
            } catch (e: IOException){
                BooksUiState.Error
            } catch (e: HttpException){
                BooksUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BooksApplication)
                val bookCoverRepository = application.container.booksRepository
                val booksIdRepository = application.container.booksIdRepository
                BooksViewModel(
                    bookCoverRepository = bookCoverRepository,
                    booksIdRepository = booksIdRepository
                )
            }
        }
    }
}