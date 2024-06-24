package com.lucas.breweries.presentation.scenes.breweryDetails

import com.lucas.breweries.domain.model.Brewery

sealed class BreweryDetailsUiState {
    data class Success(val brewery: Brewery) : BreweryDetailsUiState()
    data object Loading : BreweryDetailsUiState()
    data object Error : BreweryDetailsUiState()
}