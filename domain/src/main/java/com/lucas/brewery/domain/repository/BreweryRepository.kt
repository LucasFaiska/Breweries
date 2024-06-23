package com.lucas.brewery.domain.repository

import androidx.paging.PagingData
import com.lucas.brewery.domain.model.Brewery
import kotlinx.coroutines.flow.Flow

interface BreweryRepository {
    suspend fun getBreweries() : Flow<PagingData<Brewery>>
}