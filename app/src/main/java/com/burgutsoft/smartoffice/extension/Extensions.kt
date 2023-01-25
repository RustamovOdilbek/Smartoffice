package com.burgutsoft.smartoffice.extension

import android.view.View

fun View.show() = run {
    this.visibility = View.VISIBLE
}

fun View.hide() = run {
    this.visibility = View.GONE
}