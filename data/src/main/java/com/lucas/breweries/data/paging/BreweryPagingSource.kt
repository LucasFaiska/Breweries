package com.lucas.breweries.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lucas.breweries.data.core.remote.network.NetworkResponse
import com.lucas.breweries.data.datasource.BreweryDataSource
import com.lucas.breweries.data.mapper.toBrewery
import com.lucas.breweries.domain.model.Brewery

class BreweryPagingSource(
    private val breweryDataSource: BreweryDataSource
) : PagingSource<Int, Brewery>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Brewery> {
        val currentPage = params.key ?: 1
        return when (val response =
            breweryDataSource.getBreweries(currentPage)) {
            is NetworkResponse.Success -> {
                val breweries = response.body
                LoadResult.Page(
                    data = breweries.map { it.toBrewery() },
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (breweries.isEmpty()) null else currentPage + 1
                )
            }

            is NetworkResponse.Error -> {
                LoadResult.Error(response.error)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Brewery>): Int? {
        return state.anchorPosition
    }
}