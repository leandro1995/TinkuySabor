package com.leandro1995.tinkuysabor.intent.action

sealed class HomeIntentAction {
    data object InitView : HomeIntentAction()
    data object LoadingLocationGone : HomeIntentAction()
}