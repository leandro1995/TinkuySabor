package com.leandro1995.tinkuysabor.intent.config.action

import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.intent.callback.action.HomeIntentActionCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient

class HomeIntentActionConfig(
    private val homeIntentAction: HomeIntentAction?,
    private val homeIntentActionCallBack: HomeIntentActionCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (homeIntentAction) {
            is HomeIntentAction -> {
                homeIntentActionCallBack?.view(view = homeIntentAction)
            }

            null -> {
                homeIntentActionCallBack?.initView()
            }
        }
    }
}