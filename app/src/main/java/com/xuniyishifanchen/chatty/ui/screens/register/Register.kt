/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty.ui.screens.register

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.xuniyishifanchen.chatty.R
import com.xuniyishifanchen.chatty.ui.compoents.VerticalSpacer

@Composable
fun Register() {

    var imageUri by rememberSaveable { mutableStateOf<Uri?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 35.dp, vertical = 48.dp)
        ) {
            Text(
                text = stringResource(id = R.string.chatty_string_register_account),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
            VerticalSpacer(value = 15.dp)

        }
    }
}