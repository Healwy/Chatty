/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty.ui.utils

import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder

fun NavOptionsBuilder.popUpAllBackStackEntry(navController: NavHostController) {
    navController.backQueue.reversed().forEach {
        it.destination.route?.let { route ->
            this.popUpTo(route) { inclusive = true }
        }
    }
}
