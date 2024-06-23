package com.lucas.breweries.presentation.scenes.breweriesList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.lucas.breweries.R
import com.lucas.breweries.domain.model.Brewery
import com.lucas.breweries.presentation.components.ErrorScreen
import com.lucas.breweries.presentation.components.LoadingScreen
import com.lucas.breweries.presentation.theme.FireBrick
import com.lucas.breweries.presentation.theme.Timberwolf
import com.lucas.breweries.presentation.theme.Typography

@Composable
fun BreweriesListScreen(uiState: BreweriesListUiState) {
    when (uiState) {
        is BreweriesListUiState.Loading -> {
            LoadingScreen()
        }

        is BreweriesListUiState.Success -> {
            BreweriesListSuccessScreenContent(uiState = uiState)
        }

        is BreweriesListUiState.Error -> {
            ErrorScreen {

            }
        }
    }
}

@Composable
fun BreweriesListSuccessScreenContent(uiState: BreweriesListUiState.Success) {
    val breweries: LazyPagingItems<Brewery> =
        uiState.breweries.collectAsLazyPagingItems()

    Column(
        Modifier
            .fillMaxSize()
            .testTag(successScreenTesTag)
    ) {

        BreweriesListScreenTitle(breweries)
        BreweriesList(breweries)
    }
}

@Composable
private fun BreweriesListScreenTitle(breweries: LazyPagingItems<Brewery>) {
    Text(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.default_padding))
            .testTag(screenTitleTestTag),
        style = Typography.h1,
        color = Timberwolf,
        text = stringResource(
            id = R.string.breweries_list_title,
            breweries.itemCount
        )
    )
}

@Composable
private fun BreweriesList(breweries: LazyPagingItems<Brewery>) {

    LazyColumn {
        items(breweries.itemCount) { index ->
            breweries[index]?.let { brewery ->
                BreweryItem(brewery)
            }
        }
    }

}

@Composable
private fun BreweryItem(brewery: Brewery) {
    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.default_padding))
            .testTag(breweryItemTestTag)
    ) {
        Text(text = brewery.name)
        Text(text = brewery.city)
        Text(text = brewery.state)
    }
}

@Composable
private fun ColumnScope.BottomLoadingIndicator() {
    CircularProgressIndicator(
        modifier = Modifier
            .testTag(bottomLoadingIndicatorTestTag)
            .size(70.dp)
            .padding(dimensionResource(id = R.dimen.default_padding))
            .align(Alignment.CenterHorizontally),
        color = FireBrick
    )
}

const val screenTitleTestTag = "screenTitleTestTag"
const val successScreenTesTag = "successScreenTesTag"
const val breweriesListTestTag = "breweriesListTestTag"
const val breweryItemTestTag = "breweryItemTestTag"
const val bottomLoadingIndicatorTestTag = "bottomLoadingIndicatorTestTag"