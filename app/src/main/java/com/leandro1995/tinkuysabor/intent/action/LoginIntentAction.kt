package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.fcm.login.FCMGoogleLogin

sealed class LoginIntentAction {
    data object InitView : LoginIntentAction()

    data class GoogleLogin(val fcmGoogleLogin: FCMGoogleLogin) : LoginIntentAction()
}