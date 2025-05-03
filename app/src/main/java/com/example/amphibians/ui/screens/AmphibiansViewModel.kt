package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.amphibians.model.AmphibiansCard
import com.example.amphibians.data.AmphibiansCardsRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.amphibians.AmphibiansCardsApplication
import kotlinx.coroutines.launch
import java.io.IOException


sealed interface AmphibiansUiState {
    data class Success(val cards: List<AmphibiansCard>) : AmphibiansUiState
    data object Error : AmphibiansUiState
    data object Loading : AmphibiansUiState
}

class AmphibiansViewModel(
    private val amphibiansCardsRepository: AmphibiansCardsRepository) : ViewModel() {
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibiansCards()
    }

    fun getAmphibiansCards() {
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                AmphibiansUiState.Success(amphibiansCardsRepository.getAmphibiansCards())
            } catch (e: IOException) {
                AmphibiansUiState.Error
            } catch (e: HttpException) {
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansCardsApplication)
                val amphibiansCardsRepository = application.container.amphibiansCardRepository
                AmphibiansViewModel(amphibiansCardsRepository = amphibiansCardsRepository)
            }
        }
    }
}