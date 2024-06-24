package com.lucas.breweries.presentation.scenes.breweryDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.lucas.breweries.R
import com.lucas.breweries.domain.model.Brewery
import com.lucas.breweries.presentation.components.ErrorScreen
import com.lucas.breweries.presentation.components.LoadingScreen
import com.lucas.breweries.presentation.theme.Onyx
import com.lucas.breweries.presentation.theme.Timberwolf
import com.lucas.breweries.presentation.theme.Typography

@Composable
fun BreweryDetailsScreen(uiState: BreweryDetailsUiState) {

    when (uiState) {
        is BreweryDetailsUiState.Success -> {
            BreweryDetailsSuccessContent(brewery = uiState.brewery)
        }

        is BreweryDetailsUiState.Loading -> {
            LoadingScreen()
        }

        is BreweryDetailsUiState.Error -> {
            ErrorScreen {
            }
        }
    }

}

@Composable
fun BreweryDetailsSuccessContent(brewery: Brewery) {
    Column(
        modifier = Modifier
            .background(color = Onyx)
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.default_padding)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding))
    ) {
        Text(
            style = Typography.h1,
            color = Timberwolf,
            text = brewery.name
        )

        Text(
            text = stringResource(R.string.type_info, brewery.type),
            style = Typography.body1,
            color = Timberwolf
        )

        Text(
            text = stringResource(
                R.string.address_info,
                brewery.address,
                brewery.city,
                brewery.state,
                brewery.country,
                brewery.postalCode
            ),
            style = Typography.body1,
            color = Timberwolf
        )

        Text(
            text = stringResource(R.string.phone_info, brewery.phone),
            style = Typography.body1,
            color = Timberwolf
        )

        Text(
            text = stringResource(R.string.website_info, brewery.site),
            style = Typography.body1,
            color = Timberwolf
        )
    }
}