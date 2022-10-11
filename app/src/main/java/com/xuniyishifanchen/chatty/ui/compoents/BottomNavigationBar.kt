/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty.ui.compoents

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.xuniyishifanchen.chatty.R

@Composable
fun BottomNavigationBar(
    selectedScreenIndex: Int,
    onClick: (targetIndex: Int) -> Unit
) {
    NavigationBar(modifier = Modifier.navigationBarsPadding()) {
        BottomScreen.values().forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = selectedScreenIndex == index,
                onClick = { onClick(index) },
                icon = {
                    Icon(
                        imageVector = if (selectedScreenIndex == index) {
                            screen.selectedIcon
                        } else {
                            screen.unSelectedIcon
                        },
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(stringResource(id = screen.label))
                }
            )
        }
    }
}

enum class BottomScreen(
    @StringRes val label: Int,
    val unSelectedIcon: ImageVector,
    val selectedIcon: ImageVector,
) {
    Message(R.string.chatty_string_message, Icons.Outlined.Chat, Icons.Filled.Chat),
    Contract(R.string.chatty_string_contract, Icons.Outlined.Group, Icons.Filled.Group),
    Explore(R.string.chatty_string_explore, Icons.Outlined.Explore, Icons.Filled.Explore)
}