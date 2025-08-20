package com.leandro1995.tinkuysabor.intent.callback

import com.leandro1995.tinkuysabor.intent.callback.ambient.IntentCallBackAmbient
import com.leandro1995.tinkuysabor.model.design.Loading

interface HomeIntentCallBack : IntentCallBackAmbient {
    fun loadingLocation(loading: Loading)
    fun verifyLocation()
}