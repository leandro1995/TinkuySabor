package com.leandro1995.tinkuysabor.model.design

import android.content.Context
import androidx.annotation.StringRes

class Message(@param:StringRes private val descriptionStringRes: Int) {

    fun description(context: Context) = context.getString(descriptionStringRes)
}