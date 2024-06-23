package com.lucas.breweries.data.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lucas.breweries.data.core.remote.BreweryApi
import com.lucas.breweries.data.core.remote.network.NetworkResponseAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideNetworkResponseAdapterFactory(): NetworkResponseAdapterFactory {
        return NetworkResponseAdapterFactory()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gson: Gson,
        networkResponseAdapterFactory: NetworkResponseAdapterFactory
    ): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(networkResponseAdapterFactory)
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideBreweryApi(retrofit: Retrofit): BreweryApi =
        retrofit.create(BreweryApi::class.java)

    private const val TIMEOUT = 30L
    private const val BASE_URL = "https://api.openbrewerydb.org/v1/"
}