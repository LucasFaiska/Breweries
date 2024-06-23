package com.lucas.breweries.data.core.remote

import com.lucas.breweries.data.core.remote.network.NetworkResponse
import com.lucas.breweries.data.core.remote.dto.BreweryResponse
import retrofit2.http.GET

interface BreweryApi {

    @GET("breweries?page={page},per_page=${BREWERIES_PAGE_SIZE}")
    suspend fun getBreweries(page: Int): NetworkResponse<List<BreweryResponse>>

    companion object {
        const val BREWERIES_PAGE_SIZE = 30
    }
}