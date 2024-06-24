package com.lucas.breweries.data.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.lucas.breweries.data.core.remote.BreweryApi
import com.lucas.breweries.data.core.remote.network.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkModuleTest {

    @Test
    fun `Given a NetworkModule, When provideGson, Then returns the expected gson setup`() {
        val expectedGson = GsonBuilder()
            .setLenient()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()

        val providedGson = NetworkModule.provideGson()

        assertEquals(
            expectedGson.fieldNamingStrategy(),
            providedGson.fieldNamingStrategy()
        )
    }

    @Test
    fun `Given a NetworkModule, When provideHttpClient, Then returns the expected OkHttpClient setup`() {
        val expectedOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(NetworkModule.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NetworkModule.TIMEOUT, TimeUnit.SECONDS)
            .build()

        val providedHttpClient = NetworkModule.provideHttpClient()

        assertEquals(
            expectedOkHttpClient.connectTimeoutMillis,
            providedHttpClient.connectTimeoutMillis
        )
        assertEquals(
            expectedOkHttpClient.readTimeoutMillis,
            providedHttpClient.readTimeoutMillis
        )
    }

    @Test
    fun `Given a NetworkModule, When provideNetworkResponseAdapterFactory, Then returns the expected NetworkResponseAdapterFactory setup`() {
        val expectedNetworkResponseAdapterFactory =
            NetworkResponseAdapterFactory()

        val providedNetworkResponseAdapterFactory =
            NetworkModule.provideNetworkResponseAdapterFactory()

        assertEquals(
            expectedNetworkResponseAdapterFactory::class.java,
            providedNetworkResponseAdapterFactory::class.java
        )
    }

    @Test
    fun `Given a NetworkModule, When provideRetrofitInstance, Then returns the expected Retrofit setup`() {
        val expectedRetrofit =
            Retrofit.Builder().client(NetworkModule.provideHttpClient())
                .addConverterFactory(GsonConverterFactory.create(NetworkModule.provideGson()))
                .addCallAdapterFactory(NetworkResponseAdapterFactory())
                .baseUrl(NetworkModule.BASE_URL)
                .build()

        val providedRetrofit = NetworkModule.provideRetrofitInstance(
            NetworkModule.provideHttpClient(),
            NetworkModule.provideGson(),
            NetworkModule.provideNetworkResponseAdapterFactory()
        )

        assertEquals(expectedRetrofit.baseUrl(), providedRetrofit.baseUrl())
        assertEquals(
            expectedRetrofit.callAdapterFactories()::class.java,
            providedRetrofit.callAdapterFactories()::class.java
        )
        assertEquals(
            expectedRetrofit.converterFactories()::class.java,
            providedRetrofit.converterFactories()::class.java
        )
    }

    @Test
    fun `Given a NetworkModule, When provideBreweryApi, Then returns the expected BreweryApi setup`() {
        val expectedBreweryApi = NetworkModule.provideRetrofitInstance(
            NetworkModule.provideHttpClient(),
            NetworkModule.provideGson(),
            NetworkModule.provideNetworkResponseAdapterFactory()
        ).create(BreweryApi::class.java)

        val providedBreweryApi = NetworkModule.provideBreweryApi(
            NetworkModule.provideRetrofitInstance(
                NetworkModule.provideHttpClient(),
                NetworkModule.provideGson(),
                NetworkModule.provideNetworkResponseAdapterFactory()
            )
        )

        assertEquals(
            expectedBreweryApi::class.java,
            providedBreweryApi::class.java
        )
    }

}