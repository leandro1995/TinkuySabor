package com.leandro1995.tinkuysabor.intent.event

sealed class ProfileIntentEvent {

    data object StartLoginActivity : ProfileIntentEvent()
}