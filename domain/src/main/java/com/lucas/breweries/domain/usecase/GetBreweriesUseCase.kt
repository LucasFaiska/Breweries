package com.lucas.breweries.domain.usecase

import androidx.paging.PagingData
import com.lucas.breweries.domain.model.Brewery
import com.lucas.breweries.domain.repository.BreweryRepository
import kotlinx.coroutines.flow.Flow

interface GetBreweriesUseCase {

    suspend operator fun invoke(): Flow<PagingData<Brewery>>
}

class GetBreweriesUseCaseImpl(
    private val repository: BreweryRepository
) : GetBreweriesUseCase {

    override suspend operator fun invoke() = repository.getBreweries()
}