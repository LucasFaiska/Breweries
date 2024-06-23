package com.lucas.breweries.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.lucas.breweries.navigation.MainNavGraph
import com.lucas.breweries.navigation.NavigationActions
import com.lucas.breweries.navigation.NavigationComponent
import com.lucas.breweries.navigation.Navigator
import com.lucas.breweries.presentation.theme.AppTheme

@Composable
fun MainScreen(navigator: Navigator) {
    AppTheme {
        val navController = rememberNavController()

        val navigationActions = remember(navController) {
            NavigationActions(navController)
        }

        NavigationComponent(
            navigator = navigator,
            navigationActions = navigationActions
        )

        MainNavGraph(navController = navController)
    }
}