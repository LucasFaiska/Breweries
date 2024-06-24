package com.lucas.breweries.domain.repository

import androidx.paging.PagingData
import com.lucas.breweries.domain.model.Brewery
import kotlinx.coroutines.flow.Flow

interface BreweryRepository {
    suspend fun getBreweries() : Flow<PagingData<Brewery>>
    suspend fun getBrewery(id: String) : Flow<Brewery>
}