package com.leandro1995.tinkuysabor.intent.config.action

import com.leandro1995.tinkuysabor.intent.action.TourismListIntentAction
import com.leandro1995.tinkuysabor.intent.callback.action.TourismListIntentActionCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient

class TourismListIntentActionConfig(
    private val tourismListIntentAction: TourismListIntentAction?,
    private val tourismListIntentActionCallBack: TourismListIntentActionCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (tourismListIntentAction) {
            is TourismListIntentAction -> {
                tourismListIntentActionCallBack?.view(view = tourismListIntentAction)
            }

            null -> {
                tourismListIntentActionCallBack?.initView()
            }
        }
    }
}