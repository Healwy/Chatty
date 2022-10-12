/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty.ui.screens.splash


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.xuniyishifanchen.chatty.R
import com.xuniyishifanchen.chatty.ui.compoents.CenterRow
import com.xuniyishifanchen.chatty.ui.screens.AppScreen
import com.xuniyishifanchen.chatty.ui.utils.LocalNavController
import kotlinx.coroutines.delay

@Composable
fun Splash() {
    val navController = LocalNavController.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CenterRow {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h1,
                color = Color(0xFF0E4A86),
                fontFamily = FontFamily.Cursive
            )

        }
    }

    LaunchedEffect(Unit) {
        delay(500)
        navController.navigate(AppScreen.login) {
            popUpTo(AppScreen.splash) {
                inclusive = true
            }
        }
    }
}

@Preview
@Composable
fun SplashPreview() {
    Splash()
}

