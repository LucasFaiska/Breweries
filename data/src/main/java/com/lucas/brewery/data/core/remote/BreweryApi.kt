package com.lucas.brewery.data.core.remote

import com.lucas.brewery.data.core.remote.network.NetworkResponse
import com.lucas.brewery.data.core.remote.dto.BreweryResponse
import retrofit2.http.GET

interface BreweryApi {

    @GET("breweries?page={page},per_page=${BREWERIES_PAGE_SIZE}")
    suspend fun getBreweries(page: Int): NetworkResponse<List<BreweryResponse>>

    companion object {
        const val BREWERIES_PAGE_SIZE = 30
    }
}