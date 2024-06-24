package com.lucas.breweries.presentation.scenes.breweryDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.breweries.domain.usecase.GetBreweryDetailsUseCase
import com.lucas.breweries.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class BreweryDetailsViewModel @Inject constructor(
    private val getBreweryDetailsUseCase: GetBreweryDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var breweryId: String =
        savedStateHandle[Destination.BreweryDetails.params.first()]
            ?: throw IllegalArgumentException("Brewery ID not found")

    val uiState: StateFlow<BreweryDetailsUiState> = flow {
        getBreweryDetailsUseCase(breweryId)
            .catch {
                emit(BreweryDetailsUiState.Error)
            }
            .collect {
                emit(BreweryDetailsUiState.Success(it))
            }
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        BreweryDetailsUiState.Loading
    )
}