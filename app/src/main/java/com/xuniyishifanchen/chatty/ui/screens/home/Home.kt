/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty.ui.screens.home

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.xuniyishifanchen.chatty.ui.compoents.BottomNavigationBar
import com.xuniyishifanchen.chatty.ui.compoents.BottomScreen
import com.xuniyishifanchen.chatty.ui.screens.home.contract.Contract
import com.xuniyishifanchen.chatty.ui.screens.home.explore.Explore
import com.xuniyishifanchen.chatty.ui.screens.home.message.Message
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun Home() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    var selectedScreen by remember { mutableStateOf(0) }

    ModalNavigationDrawer(
        drawerContent = {

        },
        drawerState = drawerState
    ) {
        Scaffold(bottomBar = {
            BottomNavigationBar(selectedScreen) {
                coroutineScope.launch {
                    pagerState.scrollToPage(it)
                }
            }
        }) {
            HorizontalPager(
                count = BottomScreen.values().size,
                state = pagerState,
                contentPadding = it,
                userScrollEnabled = false
            ) { pageIndex ->
                when (BottomScreen.values()[pageIndex]) {
                    BottomScreen.Message -> Message()
                    BottomScreen.Contract -> Contract()
                    BottomScreen.Explore -> Explore()
                }
            }
        }
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            selectedScreen = page
        }
    }
}