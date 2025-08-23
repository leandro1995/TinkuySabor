package com.leandro1995.tinkuysabor.intent.config.event

import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient
import com.leandro1995.tinkuysabor.intent.event.ProfileIntentEvent
import com.leandro1995.tinkuysabor.intent.callback.event.ProfileIntentEventCallBack

class ProfileIntentEventConfig(
    private val profileIntentEvent: ProfileIntentEvent,
    private val profileIntentEventCallBack: ProfileIntentEventCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (profileIntentEvent) {
            ProfileIntentEvent.StartLoginActivity -> {
                profileIntentEventCallBack?.startLoginActivity()
            }
        }
    }
}