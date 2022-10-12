/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty.ui.utils

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

val LocalNavController = compositionLocalOf<NavHostController> {
    error("CompositionLocal LocalNavControl not present")
}

val LocalOnBackPressedDispatcher = staticCompositionLocalOf<OnBackPressedDispatcher> {
    error("CompositionLocal LocalOnBackPressedDispatcher not present")
}