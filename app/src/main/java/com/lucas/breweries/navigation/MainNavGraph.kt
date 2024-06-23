package com.lucas.breweries.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lucas.breweries.presentation.scenes.breweriesList.BreweriesListScreen
import com.lucas.breweries.presentation.scenes.breweriesList.BreweriesListViewModel

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
            val viewModel = hiltViewModel<BreweriesListViewModel>()
            BreweriesListScreen(uiState = viewModel.uiState.collectAsState().value)
        }

        composable(route = Destination.BreweryDetails.fullRoute) {

        }
    }
}