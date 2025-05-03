package com.example.amphibians.fake

import com.example.amphibians.data.AmphibiansCardsRepository
import com.example.amphibians.model.AmphibiansCard

class FakeAmphibiansCardsRepository : AmphibiansCardsRepository {
    override suspend fun getAmphibiansCards(): List<AmphibiansCard> {
        return FakeDataSource.cardsList
    }
}