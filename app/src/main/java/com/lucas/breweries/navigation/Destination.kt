package com.lucas.breweries.navigation

sealed class Destination(
    val route: String,
    val params: List<String> = emptyList()
) {

    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    data object BreweriesList : Destination(BREWERIES_LIST_ROUTE)

    data object BreweryDetails : Destination(
        BREWERY_DETAILS_ROUTE,
        listOf(BREWERY_DETAILS_ROUTE_BREWERY_ID)
    )

    companion object {
        private const val BREWERIES_LIST_ROUTE = "breweriesList"
        private const val BREWERY_DETAILS_ROUTE = "breweryDetails"
        private const val BREWERY_DETAILS_ROUTE_BREWERY_ID = "breweryId"
    }
}