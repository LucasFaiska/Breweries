package com.lucas.breweries.data.core.remote

import com.lucas.breweries.data.core.remote.network.NetworkResponse
import com.lucas.breweries.data.core.remote.dto.BreweryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweryApi {

    @GET("breweries")
    suspend fun getBreweries(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = BREWERIES_PAGE_SIZE
    ): NetworkResponse<List<BreweryResponse>>

    companion object {
        const val BREWERIES_PAGE_SIZE = 30
    }
}