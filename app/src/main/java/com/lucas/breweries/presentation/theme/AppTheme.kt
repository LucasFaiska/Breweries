package com.lucas.breweries.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(
            primary = Onyx,
            primaryVariant = Timberwolf,
            secondary = BurntUmber,
            secondaryVariant = FireBrick
        ),
        typography = Typography,
        content = content
    )
}