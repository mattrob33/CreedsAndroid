package com.mattrobertson.creeds.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Anchor
import androidx.compose.material.icons.rounded.Book
import androidx.compose.material.icons.rounded.FormatListNumbered
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.mattrobertson.creeds.R

sealed class Screen(val route: String, @StringRes val label: Int, val icon: ImageVector) {
    object Creeds : Screen("creeds", R.string.creeds, Icons.Rounded.Anchor)
    object Confessions : Screen("confessions", R.string.confessions, Icons.Rounded.Book)
    object Catechisms : Screen("catechisms", R.string.catechisms, Icons.Rounded.FormatListNumbered)
    object Settings : Screen("settings", R.string.settings, Icons.Rounded.Settings)
}