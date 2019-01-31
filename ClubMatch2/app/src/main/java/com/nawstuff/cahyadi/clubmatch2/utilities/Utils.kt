package com.nawstuff.cahyadi.clubmatch2.utilities

import android.content.Context
import android.view.View
import com.nawstuff.cahyadi.clubmatch2.database.FavoriteDBHelper


fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

val Context.db: FavoriteDBHelper
    get() = FavoriteDBHelper.getInstance(applicationContext)