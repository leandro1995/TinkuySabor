package com.leandro1995.tinkuysabor.intent.config.event

import com.leandro1995.tinkuysabor.intent.callback.event.SplashIntentEventCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient
import com.leandro1995.tinkuysabor.intent.event.SplashIntentEvent

class SplashIntentEventConfig(
    private val splashIntentEvent: SplashIntentEvent,
    private val splashIntentEventCallBack: SplashIntentEventCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (splashIntentEvent) {
            is SplashIntentEvent.StartActivity -> {
                splashIntentEventCallBack?.startActivity(splashIntentEvent.activity)
            }
        }
    }
}