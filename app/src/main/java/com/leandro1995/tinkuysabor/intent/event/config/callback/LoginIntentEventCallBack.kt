package com.leandro1995.tinkuysabor.intent.event.config.callback

import com.leandro1995.tinkuysabor.fcm.authentication.GoogleFCMAuthentication

interface LoginIntentEventCallBack {

    fun googleLogin()

    fun googleAuthentication(googleFCMAuthentication: GoogleFCMAuthentication)
}