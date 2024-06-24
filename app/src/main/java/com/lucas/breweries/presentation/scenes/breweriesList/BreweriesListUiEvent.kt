package com.lucas.breweries.presentation.scenes.breweriesList

sealed class BreweriesListUiEvent {
    data class NavigateToBreweryDetails(
        val breweryId: String
    ) : BreweriesListUiEvent()
    
    data object OnRetryButtonClick : BreweriesListUiEvent()
}
