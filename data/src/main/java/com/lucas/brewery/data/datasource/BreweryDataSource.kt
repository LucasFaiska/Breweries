package com.lucas.brewery.data.datasource

import com.lucas.brewery.data.core.remote.dto.BreweryResponse
import com.lucas.brewery.data.core.remote.network.NetworkResponse

interface BreweryDataSource {
    suspend fun getBreweries(page: Int): NetworkResponse<List<BreweryResponse>>
}