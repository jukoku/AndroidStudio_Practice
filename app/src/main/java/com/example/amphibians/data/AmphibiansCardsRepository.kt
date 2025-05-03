package com.example.amphibians.data

import com.example.amphibians.model.AmphibiansCard
import com.example.amphibians.network.AmphibiansApiService

interface AmphibiansCardsRepository {
    suspend fun getAmphibiansCards(): List<AmphibiansCard>
}

class NetworkAmphibiansCardsRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansCardsRepository{
    override suspend fun getAmphibiansCards(): List<AmphibiansCard>
    = amphibiansApiService.getCards()
}