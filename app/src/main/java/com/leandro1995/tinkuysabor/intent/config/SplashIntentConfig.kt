package com.leandro1995.tinkuysabor.intent.config

import com.leandro1995.tinkuysabor.intent.action.SplashIntentAction
import com.leandro1995.tinkuysabor.intent.callback.SplashIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient

class SplashIntentConfig(
    private val splashIntentAction: SplashIntentAction,
    private val splashIntentCallBack: SplashIntentCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (splashIntentAction) {
            SplashIntentAction.InitView -> {
                splashIntentCallBack?.initView()
            }

            is SplashIntentAction.ViewActivity -> {
                splashIntentCallBack?.viewActivity(activity = splashIntentAction.activity)
            }
        }
    }
}