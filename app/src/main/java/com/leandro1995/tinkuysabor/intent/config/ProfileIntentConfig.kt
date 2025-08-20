package com.leandro1995.tinkuysabor.intent.config

import com.leandro1995.tinkuysabor.intent.action.ProfileIntentAction
import com.leandro1995.tinkuysabor.intent.callback.ProfileIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient

class ProfileIntentConfig(
    private val profileIntentAction: ProfileIntentAction?,
    private val profileIntentCallBack: ProfileIntentCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (profileIntentAction) {
            ProfileIntentAction.InitView -> {
                profileIntentCallBack?.initView()
            }

            is ProfileIntentAction.StartLoginActivity -> {
                profileIntentCallBack?.startLoginActivity(loginActivity = profileIntentAction.loginActivity)
            }

            null -> {}
        }
    }
}