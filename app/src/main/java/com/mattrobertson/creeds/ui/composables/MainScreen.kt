package com.mattrobertson.creeds.ui.composables

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mattrobertson.creeds.ui.composables.creeds.CreedsScreen
import com.mattrobertson.creeds.ui.theme.CreedsTheme

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
@Preview
fun MainScreen() {
    CreedsTheme {
        CreedsScreen()
    }
}