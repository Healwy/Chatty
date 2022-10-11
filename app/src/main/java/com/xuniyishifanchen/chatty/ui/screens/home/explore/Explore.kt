/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty.ui.screens.home.explore

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Explore() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "explore")
    }
}

@Preview
@Composable
fun ExplorePreview() {
    Explore()
}
