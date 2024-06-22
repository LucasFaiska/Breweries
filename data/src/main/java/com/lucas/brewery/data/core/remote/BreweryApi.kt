package com.lucas.brewery.data.core.remote

import com.lucas.brewery.data.core.remote.network.NetworkResponse
import com.lucas.brewery.data.core.remote.dto.BreweryResponse
import retrofit2.http.GET

interface BreweryApi {

    @GET("breweries?page={page}")
    suspend fun getBreweries(page: Int): NetworkResponse<List<BreweryResponse>>


}