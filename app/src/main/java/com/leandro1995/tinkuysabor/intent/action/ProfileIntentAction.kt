package com.leandro1995.tinkuysabor.intent.action

sealed class ProfileIntentAction {
    data object InitView : ProfileIntentAction()
}