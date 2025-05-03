package com.example.amphibians

import com.example.amphibians.fake.FakeAmphibiansCardsRepository
import com.example.amphibians.fake.FakeDataSource
import com.example.amphibians.rules.TestDispatcherRule
import com.example.amphibians.ui.screens.AmphibiansUiState
import com.example.amphibians.ui.screens.AmphibiansViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AmphibiansViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun amphibiansViewModel_getAmphibiansCards_verifyAmphibiansUiStateSuccess() =
        runTest {
            val amphibiansViewModel = AmphibiansViewModel(
                amphibiansCardsRepository = FakeAmphibiansCardsRepository()
            )
            assertEquals(
                AmphibiansUiState.Success(FakeDataSource.cardsList),
                amphibiansViewModel.amphibiansUiState
            )
        }

}