package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.activity.HomeActivity
import com.leandro1995.tinkuysabor.fcm.authentication.GoogleFCMAuthentication
import com.leandro1995.tinkuysabor.fcm.login.GoogleFCMLogin

sealed class LoginIntentAction {
    data object InitView : LoginIntentAction()

    data class GoogleLogin(val googleFCMLogin: GoogleFCMLogin) : LoginIntentAction()

    data class GoogleAuthentication(val googleFCMAuthentication: GoogleFCMAuthentication) :
        LoginIntentAction()

    data class StartHomeActivity(val homeActivity: HomeActivity) : LoginIntentAction()
}