/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty.ui.screens.login


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xuniyishifanchen.chatty.R
import com.xuniyishifanchen.chatty.ui.compoents.CenterRow
import com.xuniyishifanchen.chatty.ui.compoents.HorizontalSapcer
import com.xuniyishifanchen.chatty.ui.compoents.VerticalSpacer
import com.xuniyishifanchen.chatty.ui.screens.AppScreen
import com.xuniyishifanchen.chatty.ui.utils.LocalNavControl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {

    val navController = LocalNavControl.current

    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 48.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 35.dp)
        ) {

            Text(
                text = "Chatty",
                fontSize = 64.sp,
                color = Color(0xFF0E4A86),
                fontFamily = FontFamily.Cursive
            )
            VerticalSpacer(value = 20.dp)
            OutlinedTextField(
                value = userName,
                onValueChange = {
                    userName = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.chatty_string_user_name))
                },
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.expand),
                        contentDescription = null
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    containerColor = Color.Transparent
                )
            )
            VerticalSpacer(value = 10.dp)
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.chatty_string_password))
                },
                shape = RoundedCornerShape(8.dp),
                visualTransformation = if (passwordHidden) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
                trailingIcon = {
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
                        Icon(
                            painter = painterResource(id = R.drawable.visibility),
                            contentDescription = null
                        )
                    }
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    containerColor = Color.Transparent
                )
            )
            VerticalSpacer(value = 20.dp)
            Button(
                onClick = {
                    navController.navigate(AppScreen.main) {
                        popUpTo(AppScreen.login) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                elevation = ButtonDefaults.buttonElevation(10.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.login), contentDescription = null)
                HorizontalSapcer(value = 5.dp)
                Text(text = stringResource(id = R.string.chatty_string_login))
            }
            VerticalSpacer(value = 15.dp)
            CenterRow {
                Text(
                    text = stringResource(id = R.string.chatty_string_forget_password),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.clickable {
                        navController.navigate(AppScreen.register)
                    },
                    text = stringResource(id = R.string.chatty_string_register),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

