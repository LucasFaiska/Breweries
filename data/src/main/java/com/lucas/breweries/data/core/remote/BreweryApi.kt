package com.lucas.breweries.data.core.remote

import com.lucas.breweries.data.core.remote.dto.BreweryResponse
import com.lucas.breweries.data.core.remote.network.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BreweryApi {

    @GET("breweries")
    suspend fun getBreweries(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = BREWERIES_PAGE_SIZE
    ): NetworkResponse<List<BreweryResponse>>

    @GET("breweries/{id}")
    suspend fun getBrewery(@Path("id") id: String): NetworkResponse<BreweryResponse>

    companion object {
        const val BREWERIES_PAGE_SIZE = 30
    }
}