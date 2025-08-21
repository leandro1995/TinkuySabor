package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.intent.action.config.ServiceIntentActionConfig
import com.leandro1995.tinkuysabor.model.design.Loading

sealed class HomeIntentAction {
    data object InitView : HomeIntentAction()
    data object VerifyLocation : HomeIntentAction()
    data object StartLocation : HomeIntentAction()
    data class LoadingLocation(val loading: Loading) : HomeIntentAction()
    data class ServiceIntent(val serviceIntentActionConfig: ServiceIntentActionConfig) :
        HomeIntentAction()
}