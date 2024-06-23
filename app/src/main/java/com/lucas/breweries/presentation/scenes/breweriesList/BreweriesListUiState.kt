package com.lucas.breweries.presentation.scenes.breweriesList

import androidx.paging.PagingData
import com.lucas.breweries.domain.model.Brewery
import kotlinx.coroutines.flow.Flow

sealed class BreweriesListUiState {
    data object Loading : BreweriesListUiState()
    data class Success(val breweries: Flow<PagingData<Brewery>>) : BreweriesListUiState()
    data object Error : BreweriesListUiState()
}