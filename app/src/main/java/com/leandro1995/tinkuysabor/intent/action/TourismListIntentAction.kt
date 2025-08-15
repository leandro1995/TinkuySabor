package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.intent.action.config.ServiceIntentActionConfig
import com.leandro1995.tinkuysabor.model.entity.Tour

sealed class TourismListIntentAction {
    data class ServiceIntent(val serviceIntentActionConfig: ServiceIntentActionConfig) :
        TourismListIntentAction()

    data class TourismArrayList(val tourismArrayList: ArrayList<Tour>) : TourismListIntentAction()
    object InitView : TourismListIntentAction()
}