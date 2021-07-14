package com.mattrobertson.creeds.ui.composables.creeds

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.mattrobertson.creeds.ui.CreedTab
import com.mattrobertson.creeds.ui.DisplaySettings
import com.mattrobertson.creeds.ui.theme.CreedsTheme
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun CreedsScreen(
    displaySettings: DisplaySettings = DisplaySettings.DEFAULT
) {
    val tabs = listOf(
        CreedTab.Apostles,
        CreedTab.Nicene,
        CreedTab.Athanasian,
        CreedTab.Chalcedonian
    )

    val pagerState = rememberPagerState(pageCount = tabs.size)

    Column {
        Tabs(tabs, pagerState)
        TabsContent(tabs, pagerState)
    }
}

@Preview
@Composable
@ExperimentalMaterialApi
@ExperimentalPagerApi
fun CreedsScreenPreview() {
    CreedsTheme {
        CreedsScreen()
    }
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun Tabs(tabs: List<CreedTab>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.primary,
        edgePadding = 20.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                color = MaterialTheme.colors.primary
            )
        }) {

        tabs.forEachIndexed { index, tab ->
            Tab(
                text = { Text(tab.creed.abbreviation) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun TabsPreview() {
    val tabs = listOf(
        CreedTab.Apostles,
        CreedTab.Nicene,
        CreedTab.Athanasian,
        CreedTab.Chalcedonian
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)

    CreedsTheme {
        Tabs(tabs = tabs, pagerState = pagerState)
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(tabs: List<CreedTab>, pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        val creed = tabs[page].creed
        CreedView(creed = creed)
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun TabsContentPreview() {
    val tabs = listOf(
        CreedTab.Apostles,
        CreedTab.Nicene,
        CreedTab.Athanasian,
        CreedTab.Chalcedonian
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)
    TabsContent(tabs = tabs, pagerState = pagerState)
}