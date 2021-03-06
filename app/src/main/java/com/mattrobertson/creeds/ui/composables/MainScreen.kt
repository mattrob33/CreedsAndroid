package com.mattrobertson.creeds.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mattrobertson.creeds.ui.Screen
import com.mattrobertson.creeds.ui.composables.catechisms.CatechismsScreen
import com.mattrobertson.creeds.ui.composables.confessions.ConfessionsScreen
import com.mattrobertson.creeds.ui.composables.creeds.CreedsScreen
import com.mattrobertson.creeds.ui.theme.AppTheme

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
@Preview
fun MainScreen() {
    AppTheme {
        val bottomNavItems = listOf(
            Screen.Creeds,
            Screen.Confessions,
            Screen.Catechisms,
            Screen.Settings
        )

        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    bottomNavItems.forEach { screen ->
                        BottomNavigationItem(
                            icon = { Icon(screen.icon, contentDescription = null) },
                            label = { Text(stringResource(screen.label)) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(navController, startDestination = Screen.Creeds.route, Modifier.padding(innerPadding)) {
                composable(Screen.Creeds.route) { CreedsScreen() }
                composable(Screen.Confessions.route) { ConfessionsScreen() }
                composable(Screen.Catechisms.route) { CatechismsScreen() }
                composable(Screen.Settings.route) {  }
            }
        }
    }
}