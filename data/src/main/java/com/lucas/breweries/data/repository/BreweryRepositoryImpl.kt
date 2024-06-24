package com.lucas.breweries.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lucas.breweries.data.core.remote.BreweryApi.Companion.BREWERIES_PAGE_SIZE
import com.lucas.breweries.data.core.remote.network.NetworkResponse
import com.lucas.breweries.data.datasource.BreweryDataSource
import com.lucas.breweries.data.mapper.toBrewery
import com.lucas.breweries.data.paging.BreweryPagingSource
import com.lucas.breweries.domain.model.Brewery
import com.lucas.breweries.domain.repository.BreweryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BreweryRepositoryImpl @Inject constructor(
    private val breweryDataSource: BreweryDataSource,
    private val coroutineDispatcher: CoroutineDispatcher
) : BreweryRepository {

    override suspend fun getBreweries(): Flow<PagingData<Brewery>> =
        withContext(coroutineDispatcher) {
            Pager(
                config = PagingConfig(pageSize = BREWERIES_PAGE_SIZE),
                pagingSourceFactory = { BreweryPagingSource(breweryDataSource) }
            ).flow
        }

    override suspend fun getBrewery(id: String): Flow<Brewery> = flow {
        breweryDataSource.getBrewery(id).run {
            if (this is NetworkResponse.Success) {
                emit(body.toBrewery())
            } else {
                throw Exception("Error fetching brewery")
            }
        }
    }.flowOn(coroutineDispatcher)
}