package com.leandro1995.tinkuysabor.intent.callback.ambient

import androidx.annotation.StringRes
import com.leandro1995.tinkuysabor.model.design.Loading

interface ServiceIntentCallBackAmbient {
    fun showLoading(loading: Loading)

    fun messageError(@StringRes idMessageError: Int)
}