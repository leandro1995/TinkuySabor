package com.leandro1995.tinkuysabor.intent.event

sealed class LoginIntentEvent {
    data object GoogleLogin : LoginIntentEvent()
}