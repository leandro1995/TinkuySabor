package com.leandro1995.tinkuysabor.intent.callback

import com.leandro1995.tinkuysabor.intent.callback.ambient.IntentCallBackAmbient

interface HomeIntentCallBack : IntentCallBackAmbient {
    fun loadingLocationGone()
    fun verifyLocation()
}