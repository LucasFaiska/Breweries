package com.lucas.breweries.navigation

sealed class NavTarget(
    val destination: Destination,
    val data: List<String> = emptyList()
) {
    data object BreweriesList : NavTarget(Destination.BreweriesList)

    data class BreweryDetails(
        val breweryId: String
    ) : NavTarget(Destination.BreweryDetails, listOf(breweryId))
}