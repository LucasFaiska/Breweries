package com.lucas.brewery.data.di

import com.lucas.brewery.core.di.IoDispatcher
import com.lucas.brewery.data.core.remote.BreweryApi
import com.lucas.brewery.data.datasource.BreweryDataSource
import com.lucas.brewery.data.datasource.BreweryRemoteDataSource
import com.lucas.brewery.data.repository.BreweryRepositoryImpl
import com.lucas.brewery.domain.repository.BreweryRepository
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
    fun provideBreweryRepository(
        breweryDataSource: BreweryDataSource,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher
    ): BreweryRepository {
        return BreweryRepositoryImpl(breweryDataSource, coroutineDispatcher)
    }

}