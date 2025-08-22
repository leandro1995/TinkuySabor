package com.leandro1995.tinkuysabor.intent.config.event

import com.leandro1995.tinkuysabor.intent.callback.LoginIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient
import com.leandro1995.tinkuysabor.intent.event.LoginIntentEvent

class LoginIntentEventConfig(
    private val loginIntentEvent: LoginIntentEvent,
    private val loginIntentCallBack: LoginIntentCallBack
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (loginIntentEvent) {

        }
    }
}