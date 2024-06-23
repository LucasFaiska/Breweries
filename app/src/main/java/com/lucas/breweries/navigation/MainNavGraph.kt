package com.lucas.breweries.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Destination.BreweriesList.fullRoute
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Destination.BreweriesList.fullRoute) {

        }

        composable(route = Destination.BreweryDetails.fullRoute) {

        }
    }
}