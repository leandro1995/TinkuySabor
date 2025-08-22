package com.leandro1995.tinkuysabor.intent.event

import com.leandro1995.tinkuysabor.fcm.authentication.GoogleFCMAuthentication

sealed class LoginIntentEvent {
    data object GoogleLogin : LoginIntentEvent()

    data class GoogleAuthentication(val googleFCMAuthentication: GoogleFCMAuthentication) :
        LoginIntentEvent()

    data object StartHomeActivity : LoginIntentEvent()
}