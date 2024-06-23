package com.lucas.breweries.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

interface Navigator {

    val navTarget: SharedFlow<NavTarget>

    suspend fun navigateTo(navTarget: NavTarget)
}

class NavigatorImpl @Inject constructor() : Navigator {

    private val _navTarget = MutableSharedFlow<NavTarget>()
    override val navTarget = _navTarget.asSharedFlow()

    override suspend fun navigateTo(navTarget: NavTarget) {
        _navTarget.emit(navTarget)
    }
}