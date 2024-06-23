package com.lucas.brewery.data.datasource

import com.lucas.brewery.data.core.remote.BreweryApi
import com.lucas.brewery.data.core.remote.dto.BreweryResponse
import com.lucas.brewery.data.core.remote.network.NetworkResponse
import javax.inject.Inject

class BreweryRemoteDataSource @Inject constructor(
    private val breweryApi: BreweryApi
) : BreweryDataSource {
    override suspend fun getBreweries(page: Int): NetworkResponse<List<BreweryResponse>> {
        return breweryApi.getBreweries(page)
    }
}