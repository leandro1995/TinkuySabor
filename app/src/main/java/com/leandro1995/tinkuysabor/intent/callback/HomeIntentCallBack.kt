package com.leandro1995.tinkuysabor.intent.callback

import com.leandro1995.tinkuysabor.intent.callback.ambient.IntentCallBackAmbient
import com.leandro1995.tinkuysabor.intent.callback.ambient.ServiceIntentCallBackAmbient
import com.leandro1995.tinkuysabor.model.design.Loading

interface HomeIntentCallBack : IntentCallBackAmbient, ServiceIntentCallBackAmbient {
    fun loadingLocation(loading: Loading)
    fun verifyLocation()
    fun startLocation()
}