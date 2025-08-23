package com.leandro1995.tinkuysabor.intent.config.event

import com.leandro1995.tinkuysabor.intent.callback.event.LoginIntentEventCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient
import com.leandro1995.tinkuysabor.intent.event.LoginIntentEvent

class LoginIntentEventConfig(
    private val loginIntentEvent: LoginIntentEvent,
    private val loginIntentEventCallBack: LoginIntentEventCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (loginIntentEvent) {
            LoginIntentEvent.GoogleLogin -> {
                loginIntentEventCallBack?.googleLogin()
            }

            is LoginIntentEvent.GoogleAuthentication -> {
                loginIntentEventCallBack?.googleAuthentication(googleFCMAuthentication = loginIntentEvent.googleFCMAuthentication)
            }

            LoginIntentEvent.StartHomeActivity -> {
                loginIntentEventCallBack?.startHomeActivity()
            }
        }
    }
}