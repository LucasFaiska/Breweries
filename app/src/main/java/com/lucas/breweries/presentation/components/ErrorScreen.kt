package com.lucas.breweries.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lucas.breweries.R
import com.lucas.breweries.presentation.theme.FireBrick
import com.lucas.breweries.presentation.theme.Timberwolf
import com.lucas.breweries.presentation.theme.Typography


@Preview
@Composable
fun ErrorScreenPreview() {
    ErrorScreen {}
}

@Composable
fun ErrorScreen(onRetryButtonClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .testTag(ErrorScreenTestTag),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ErrorMessage()
            RetryButton(onRetryButtonClick)       
        }
    }
}

@Composable
fun ErrorMessage() {
    Text(
        style = Typography.h1,
        color = Timberwolf,
        text = stringResource(id = R.string.error_screen_error_message)
    )
}

@Composable
private fun RetryButton(onRetryButtonClick: () -> Unit) {
    Button(
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.error_button_width))
            .padding(dimensionResource(id = R.dimen.default_padding)),
        onClick = { onRetryButtonClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = FireBrick)
    ) {
        Text(
            text = stringResource(id = R.string.error_screen_button_label),
            color = Color.White
        )
    }
}

const val ErrorScreenTestTag = "ErrorScreenTestTag"