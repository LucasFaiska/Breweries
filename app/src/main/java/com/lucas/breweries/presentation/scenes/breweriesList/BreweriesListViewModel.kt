package com.lucas.breweries.presentation.scenes.breweriesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.breweries.domain.usecase.GetBreweriesUseCase
import com.lucas.breweries.navigation.NavTarget
import com.lucas.breweries.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreweriesListViewModel @Inject constructor(
    private val getBreweriesUseCase: GetBreweriesUseCase,
    private val navigator: Navigator
) : ViewModel() {

    val uiState: StateFlow<BreweriesListUiState> = flow {
        emit(BreweriesListUiState.Success(getBreweriesUseCase()))
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        BreweriesListUiState.Loading
    )

    fun onEvent(event: BreweriesListUiEvent) {
        when (event) {
            is BreweriesListUiEvent.NavigateToBreweryDetails -> {
                viewModelScope.launch {
                    navigator.navigateTo(NavTarget.BreweryDetails(event.breweryId))
                }
            }

            is BreweriesListUiEvent.OnRetryButtonClick -> {
                // Handle brewery click
            }
        }
    }

}