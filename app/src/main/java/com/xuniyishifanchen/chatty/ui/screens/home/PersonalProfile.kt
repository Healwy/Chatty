/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.xuniyishifanchen.chatty.R
import com.xuniyishifanchen.chatty.ui.compoents.VerticalSpacer

@Composable
fun PersonalProfile() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .paint(
                    painter = painterResource(id = R.drawable.google_bg),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            PersonalProfileHeader()
        }
        VerticalSpacer(value = 10.dp)
        PersonalProfileDetail()
        Box(
            modifier = Modifier.fillMaxHeight(),
            contentAlignment = Alignment.BottomCenter
        ) {
            BottomSettingIcons()
        }
    }
}

@Composable
fun BottomSettingIcons() {
//    TODO("Not yet implemented")
}

@Composable
fun PersonalProfileHeader() {
//    TODO("Not yet implemented")
}

@Composable
fun PersonalProfileDetail() {
//    TODO("Not yet implemented")
}