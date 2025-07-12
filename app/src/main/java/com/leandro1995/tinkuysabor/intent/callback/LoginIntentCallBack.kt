package com.leandro1995.tinkuysabor.intent.callback

import com.leandro1995.tinkuysabor.fcm.login.FCMGoogleLogin

interface LoginIntentCallBack {
    fun initView()

    fun googleLogin(fcmGoogleLogin: FCMGoogleLogin)
}