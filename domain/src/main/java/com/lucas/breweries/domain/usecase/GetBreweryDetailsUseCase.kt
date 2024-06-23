package com.lucas.breweries.domain.usecase

import com.lucas.breweries.domain.model.Brewery
import com.lucas.breweries.domain.repository.BreweriesRepository
import kotlinx.coroutines.flow.Flow

interface GetBreweryDetailsUseCase {
    suspend operator fun invoke(id: String) : Flow<Brewery>
}

class GetBreweryDetailsUseCaseImpl(
    private val repository: BreweriesRepository
) : GetBreweryDetailsUseCase {

    override suspend operator fun invoke(id: String) = repository.getBrewery(id)
}