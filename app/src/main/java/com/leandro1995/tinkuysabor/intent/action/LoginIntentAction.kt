package com.leandro1995.tinkuysabor.intent.action

sealed class LoginIntentAction {
    data object InitView : LoginIntentAction()
}