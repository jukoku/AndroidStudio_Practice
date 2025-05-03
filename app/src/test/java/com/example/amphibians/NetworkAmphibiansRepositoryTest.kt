package com.example.amphibians

import com.example.amphibians.data.NetworkAmphibiansCardsRepository
import com.example.amphibians.fake.FakeAmphibiansApiService
import com.example.amphibians.fake.FakeDataSource
import org.junit.Test
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals



class NetworkAmphibiansRepositoryTest {
    @Test
    fun networkAmphibiansPhotosRepository_getAmphibiansCards_verifyCardList() =
        runTest {
            val repository = NetworkAmphibiansCardsRepository(
                amphibiansApiService = FakeAmphibiansApiService()
            )
            assertEquals(FakeDataSource.cardsList, repository.getAmphibiansCards())
        }
}