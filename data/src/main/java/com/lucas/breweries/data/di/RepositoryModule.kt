package com.lucas.breweries.data.di

import com.lucas.breweries.data.core.remote.BreweryApi
import com.lucas.breweries.data.datasource.BreweryDataSource
import com.lucas.breweries.data.datasource.BreweryRemoteDataSource
import com.lucas.breweries.data.repository.BreweriesRepositoryImpl
import com.lucas.breweries.domain.repository.BreweriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideBreweryDataSource(breweryApi: BreweryApi): BreweryDataSource {
        return BreweryRemoteDataSource(breweryApi)
    }

    @Singleton
    @Provides
    fun provideBreweriesRepository(
        breweryDataSource: BreweryDataSource,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher
    ): BreweriesRepository {
        return BreweriesRepositoryImpl(breweryDataSource, coroutineDispatcher)
    }

}