/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.xuniyishifanchen.chatty.ui.screens.AppScreen
import com.xuniyishifanchen.chatty.ui.screens.home.Home
import com.xuniyishifanchen.chatty.ui.screens.login.Login
import com.xuniyishifanchen.chatty.ui.screens.register.Register
import com.xuniyishifanchen.chatty.ui.screens.splash.Splash
import com.xuniyishifanchen.chatty.ui.theme.ChattyTheme
import com.xuniyishifanchen.chatty.ui.utils.HideIME
import com.xuniyishifanchen.chatty.ui.utils.LocalNavControl
import com.xuniyishifanchen.chatty.ui.utils.LocalOnBackPressedDispatcher

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ChattyTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(Color.Transparent, false)
                }

                val navController = rememberAnimatedNavController()

                DisposableEffect(Unit) {
                    val destinationChangedListener =
                        NavController.OnDestinationChangedListener { _, _, _ ->
                            HideIME()
                        }
                    navController.addOnDestinationChangedListener(destinationChangedListener)
                    onDispose {
                        navController.removeOnDestinationChangedListener(destinationChangedListener)
                    }
                }

                CompositionLocalProvider(
                    LocalNavControl provides navController,
                    LocalOnBackPressedDispatcher provides onBackPressedDispatcher
                ) {
                    ChattyNavHost(navController)
                }
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ChattyNavHost(navController: NavHostController) {
    AnimatedNavHost(navController = navController, startDestination = AppScreen.register) {
        composable(AppScreen.splash) {
            Splash()
        }
        composable(AppScreen.login) {
            Login()
        }
        composable(AppScreen.main) {
            Home()
        }
        composable(AppScreen.register) {
            Register()
        }
    }
}