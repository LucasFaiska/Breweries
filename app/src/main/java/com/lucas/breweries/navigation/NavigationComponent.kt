package com.lucas.breweries.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun NavigationComponent(
    navigator: Navigator,
    navigationActions: NavigationActions
) {
    val launchedEffectNavigationLabel = "navigation"

    LaunchedEffect(launchedEffectNavigationLabel) {
        navigator.navTarget.onEach { navTarget ->
            when (navTarget) {
                is NavTarget.BreweriesList -> {
                    navigationActions.navigateToDestination(navTarget.destination)
                }

                is NavTarget.BreweryDetails -> {
                    navigationActions.navigateToDestinationWithData(
                        navTarget.destination,
                        navTarget.data
                    )
                }
            }
        }.launchIn(this)
    }
}