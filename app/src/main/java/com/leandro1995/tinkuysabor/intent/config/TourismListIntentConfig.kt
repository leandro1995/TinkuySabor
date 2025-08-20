package com.leandro1995.tinkuysabor.intent.config

import com.leandro1995.tinkuysabor.intent.action.TourismListIntentAction
import com.leandro1995.tinkuysabor.intent.callback.TourismListIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient

class TourismListIntentConfig(
    private val tourismListIntentAction: TourismListIntentAction?,
    private val tourismListIntentCallBack: TourismListIntentCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (tourismListIntentAction) {
            TourismListIntentAction.InitView -> {
                tourismListIntentCallBack?.initView()
            }

            is TourismListIntentAction.ServiceIntent -> {
                serviceIntentActionConfig(
                    serviceIntentActionConfig = tourismListIntentAction.serviceIntentActionConfig,
                    serviceIntentCallBackAmbient = tourismListIntentCallBack
                )
            }

            is TourismListIntentAction.TourismArrayList -> {
                tourismListIntentCallBack?.tourismArrayList(tourismArrayList = tourismListIntentAction.tourismArrayList)
            }

            null -> {}
        }
    }
}