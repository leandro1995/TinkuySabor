package com.leandro1995.tinkuysabor.intent.callback

import com.leandro1995.tinkuysabor.activity.HomeActivity
import com.leandro1995.tinkuysabor.fcm.authentication.GoogleFCMAuthentication
import com.leandro1995.tinkuysabor.fcm.login.GoogleFCMLogin
import com.leandro1995.tinkuysabor.intent.callback.ambient.IntentCallBackAmbient

interface LoginIntentCallBack : IntentCallBackAmbient {
    fun googleLogin(googleFCMLogin: GoogleFCMLogin)

    fun googleAuthentication(googleFCMAuthentication: GoogleFCMAuthentication)

    fun startHomeActivity(homeActivity: HomeActivity)
}