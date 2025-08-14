package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.intent.action.config.ServiceIntentActionConfig

sealed class TourismListIntentAction {
    data class ShowLoading(val serviceIntentActionConfig: ServiceIntentActionConfig) :
        TourismListIntentAction()

    object InitView : TourismListIntentAction()
}