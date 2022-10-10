/*
 * Copyright 2022 Healer Corporation.
 */

package com.xuniyishifanchen.chatty.ui.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity


@SuppressLint("ServiceCast")
fun Context.HideIME() {
    (getSystemService(ComponentActivity.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(
            (this as Activity).currentFocus?.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
}
