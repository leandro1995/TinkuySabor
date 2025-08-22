package com.leandro1995.tinkuysabor.intent.config

import com.leandro1995.tinkuysabor.intent.action.LoginIntentAction
import com.leandro1995.tinkuysabor.intent.event.config.callback.LoginIntentEventCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient

class LoginIntentConfig(
    private val loginIntentAction: LoginIntentAction?,
    private val loginIntentEventCallBack: LoginIntentEventCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        /*when (loginIntentAction) {
            LoginIntentAction.InitView -> {
                loginIntentEventCallBack?.initView()
            }

            is LoginIntentAction.GoogleLogin -> {
                loginIntentEventCallBack?.googleLogin(googleFCMLogin = loginIntentAction.googleFCMLogin)
            }

            is LoginIntentAction.GoogleAuthentication -> {
                loginIntentEventCallBack?.googleAuthentication(googleFCMAuthentication = loginIntentAction.googleFCMAuthentication)
            }

            is LoginIntentAction.StartHomeActivity -> {
                loginIntentEventCallBack?.startHomeActivity(homeActivity = loginIntentAction.homeActivity)
            }

            null -> {}
        }*/
    }
}