package com.lucas.breweries.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.lucas.breweries.R
import com.lucas.breweries.presentation.theme.FireBrick

@Preview
@Composable
fun LoadingScreenPreview() {
    LoadingScreen()
}

@Composable
@SuppressLint("ModifierParameter")
fun LoadingScreen(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .testTag(LoadingScreenTestTag),
    size: Dp = dimensionResource(id = R.dimen.loading_progress_default_size)
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(size),
            color = FireBrick
        )
    }
}

const val LoadingScreenTestTag = "LoadingScreenTestTag"