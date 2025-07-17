package com.leandro1995.tinkuysabor.model.design

import android.content.Context
import androidx.annotation.StringRes

class Message(val context: Context, @StringRes private val descriptionStringRes: Int) {

    fun description() = context.getString(descriptionStringRes)
}