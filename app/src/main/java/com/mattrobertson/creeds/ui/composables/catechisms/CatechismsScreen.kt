package com.mattrobertson.creeds.ui.composables.catechisms

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.mattrobertson.creeds.ui.theme.AppTheme
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun CatechismsScreen() {
    val tabs = listOf(
        CatechismTab.WestminsterShorter,
        CatechismTab.WestminsterLarger
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
fun CatechismsScreenPreview() {
    AppTheme {
        CatechismsScreen()
    }
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun Tabs(tabs: List<CatechismTab>, pagerState: PagerState) {
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
                text = { Text(tab.catechism.abbreviation) },
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
        CatechismTab.WestminsterShorter,
        CatechismTab.WestminsterLarger
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)

    AppTheme {
        Tabs(tabs = tabs, pagerState = pagerState)
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(tabs: List<CatechismTab>, pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        val catechism = tabs[page].catechism
        CatechismView(catechism = catechism)
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun TabsContentPreview() {
    val tabs = listOf(
        CatechismTab.WestminsterShorter,
        CatechismTab.WestminsterLarger
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)
    TabsContent(tabs = tabs, pagerState = pagerState)
}