package com.leandro1995.tinkuysabor.intent.config

import com.leandro1995.tinkuysabor.intent.action.TourismDetailIntentAction
import com.leandro1995.tinkuysabor.intent.callback.TourismDetailIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient

class TourismDetailIntentConfig(
    private val tourismDetailIntentAction: TourismDetailIntentAction?,
    private val tourismDetailIntentCallBack: TourismDetailIntentCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (tourismDetailIntentAction) {
            TourismDetailIntentAction.InitView -> {
                tourismDetailIntentCallBack?.initView()
            }

            null -> {}
        }
    }
}