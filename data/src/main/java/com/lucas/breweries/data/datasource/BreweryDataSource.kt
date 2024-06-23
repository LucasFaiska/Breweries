package com.lucas.breweries.data.datasource

import com.lucas.breweries.data.core.remote.dto.BreweryResponse
import com.lucas.breweries.data.core.remote.network.NetworkResponse

interface BreweryDataSource {
    suspend fun getBreweries(page: Int): NetworkResponse<List<BreweryResponse>>

    suspend fun getBrewery(id: String): NetworkResponse<BreweryResponse>
}