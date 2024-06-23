package com.lucas.brewery.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lucas.brewery.data.core.remote.BreweryApi.Companion.BREWERIES_PAGE_SIZE
import com.lucas.brewery.data.datasource.BreweryDataSource
import com.lucas.brewery.data.paging.BreweryPagingSource
import com.lucas.brewery.domain.model.Brewery
import com.lucas.brewery.domain.repository.BreweryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
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
}