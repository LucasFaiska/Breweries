package com.lucas.breweries.data.di

import com.lucas.breweries.data.core.remote.BreweryApi
import com.lucas.breweries.data.datasource.BreweryDataSource
import com.lucas.breweries.data.datasource.BreweryRemoteDataSource
import com.lucas.breweries.data.repository.BreweryRepositoryImpl
import com.lucas.breweries.domain.repository.BreweryRepository
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
    ): BreweryRepository {
        return BreweryRepositoryImpl(breweryDataSource, coroutineDispatcher)
    }

}