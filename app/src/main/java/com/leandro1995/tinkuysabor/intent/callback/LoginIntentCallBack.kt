package com.leandro1995.tinkuysabor.intent.callback

import com.leandro1995.tinkuysabor.activity.HomeActivity
import com.leandro1995.tinkuysabor.fcm.authentication.FCMGoogleAuthentication
import com.leandro1995.tinkuysabor.fcm.login.FCMGoogleLogin

interface LoginIntentCallBack {
    fun initView()

    fun googleLogin(fcmGoogleLogin: FCMGoogleLogin)

    fun googleAuthentication(fcmGoogleAuthentication: FCMGoogleAuthentication)

    fun startHomeActivity(homeActivity: HomeActivity)
}