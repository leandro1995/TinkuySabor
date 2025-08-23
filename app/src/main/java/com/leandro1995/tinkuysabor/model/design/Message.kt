package com.leandro1995.tinkuysabor.model.design

import android.content.Context
import androidx.annotation.StringRes

class Message(@param:StringRes private val descriptionStringRes: Int = -1) {

    fun isVisible() = descriptionStringRes != -1

    fun description(context: Context) = context.getString(descriptionStringRes)
}