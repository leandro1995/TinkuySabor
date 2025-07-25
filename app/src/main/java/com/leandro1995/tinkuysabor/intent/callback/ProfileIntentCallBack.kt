package com.leandro1995.tinkuysabor.intent.callback

import com.leandro1995.tinkuysabor.activity.LoginActivity

interface ProfileIntentCallBack {
    fun initView()
    fun startLoginActivity(loginActivity: LoginActivity)
}