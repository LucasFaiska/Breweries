package com.lucas.brewery.data.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lucas.brewery.data.core.remote.dto.BreweryResponse
import com.lucas.brewery.data.core.remote.network.NetworkResponse
import com.lucas.brewery.data.datasource.BreweryDataSource

class BreweryPagingSource(
    private val breweryDataSource: BreweryDataSource
) : PagingSource<Int, BreweryResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BreweryResponse> {
        val currentPage = params.key ?: 1
        return when (val response = breweryDataSource.getBreweries(currentPage)) {
            is NetworkResponse.Success -> {
                val breweries = response.body
                LoadResult.Page(
                    data = breweries,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (breweries.isEmpty()) null else currentPage + 1
                )
            }

            is NetworkResponse.Error -> {
                LoadResult.Error(response.error)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, BreweryResponse>): Int? {
        return state.anchorPosition
    }
}