package com.example.amphibians.fake

import com.example.amphibians.model.AmphibiansCard
import com.example.amphibians.network.AmphibiansApiService

class FakeAmphibiansApiService : AmphibiansApiService{
    override suspend fun getCards(): List<AmphibiansCard> {
        return FakeDataSource.cardsList
    }
}