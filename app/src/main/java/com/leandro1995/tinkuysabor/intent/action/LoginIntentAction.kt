package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.activity.HomeActivity
import com.leandro1995.tinkuysabor.fcm.authentication.GoogleFCMAuthentication
import com.leandro1995.tinkuysabor.fcm.login.GoogleFCMLogin

sealed class LoginIntentAction {

    data class StartHomeActivity(val homeActivity: HomeActivity) : LoginIntentAction()
}