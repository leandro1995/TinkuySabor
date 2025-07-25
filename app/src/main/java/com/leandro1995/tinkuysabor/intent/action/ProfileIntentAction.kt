package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.activity.LoginActivity

sealed class ProfileIntentAction {
    data object InitView : ProfileIntentAction()
    data class StartLoginActivity(val loginActivity: LoginActivity) : ProfileIntentAction()
}