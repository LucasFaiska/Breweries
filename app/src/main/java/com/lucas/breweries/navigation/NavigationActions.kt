package com.lucas.breweries.navigation

import androidx.navigation.NavHostController
import androidx.navigation.NavOptions

class NavigationActions(private val navController: NavHostController) {

    fun navigateToDestination(
        destination: Destination,
        popUpTo: Boolean = false,
        popUpToDestination: Destination? = null
    ) {
        val navOptionsBuilder = NavOptions.Builder()
        if (popUpTo && popUpToDestination != null) {
            navOptionsBuilder.setPopUpTo(popUpToDestination.route, true)
        }
        val navOptions = navOptionsBuilder.build()

        navController.navigate(destination.route, navOptions)
    }

    fun navigateToDestinationWithData(
        destination: Destination,
        data: List<String>,
        popUpTo: Boolean = false,
        popUpToDestination: Destination? = null
    ) {
        val concatenatedData = data.joinToString("/")
        val url = "${destination.route}/$concatenatedData"

        val navOptionsBuilder = NavOptions.Builder()
        if (popUpTo && popUpToDestination != null) {
            navOptionsBuilder.setPopUpTo(popUpToDestination.route, true)
        }
        val navOptions = navOptionsBuilder.build()

        navController.navigate(url, navOptions)
    }

}