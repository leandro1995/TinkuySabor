package com.leandro1995.tinkuysabor.intent.config

import com.leandro1995.tinkuysabor.intent.action.LoginIntentAction
import com.leandro1995.tinkuysabor.intent.callback.LoginIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient

class LoginIntentConfig(
    private val loginIntentAction: LoginIntentAction,
    private val loginIntentCallBack: LoginIntentCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (loginIntentAction) {
            LoginIntentAction.InitView -> {
                loginIntentCallBack?.initView()
            }
        }
    }
}