package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.model.design.Loading

sealed class HomeIntentAction {
    data object InitView : HomeIntentAction()
    data class LoadingLocation(val loading: Loading) : HomeIntentAction()
}