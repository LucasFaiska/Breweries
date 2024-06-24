package com.lucas.breweries.di

import com.lucas.breweries.domain.repository.BreweryRepository
import com.lucas.breweries.domain.usecase.GetBreweriesUseCase
import com.lucas.breweries.domain.usecase.GetBreweriesUseCaseImpl
import com.lucas.breweries.domain.usecase.GetBreweryDetailsUseCase
import com.lucas.breweries.domain.usecase.GetBreweryDetailsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetBreweriesUseCase(
        breweryRepository: BreweryRepository
    ): GetBreweriesUseCase {
        return GetBreweriesUseCaseImpl(breweryRepository)
    }

    @Provides
    fun provideGetBreweryDetailsUseCase(
        breweryRepository: BreweryRepository
    ): GetBreweryDetailsUseCase {
        return GetBreweryDetailsUseCaseImpl(breweryRepository)
    }

}