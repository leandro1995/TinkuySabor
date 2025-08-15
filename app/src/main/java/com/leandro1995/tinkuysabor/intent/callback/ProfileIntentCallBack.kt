package com.leandro1995.tinkuysabor.intent.callback

import com.leandro1995.tinkuysabor.activity.LoginActivity
import com.leandro1995.tinkuysabor.intent.callback.ambient.IntentCallBackAmbient

interface ProfileIntentCallBack : IntentCallBackAmbient {
    fun startLoginActivity(loginActivity: LoginActivity)
}