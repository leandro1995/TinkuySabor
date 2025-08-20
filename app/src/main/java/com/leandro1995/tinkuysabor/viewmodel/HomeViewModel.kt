package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class HomeViewModel : ViewModelAmbient<HomeIntentAction>() {
    private fun initView() {
        value(action = HomeIntentAction.InitView)
    }

    private fun verifyLocation() {
        value(action = HomeIntentAction.VerifyLocation)
    }

    override fun intentAction(action: Int) {
        when (action) {
            INIT_VIEW -> {
                initView()
            }

            VERIFY_LOCATION -> {
                verifyLocation()
            }
        }
    }

    companion object {
        const val INIT_VIEW = 0
        const val VERIFY_LOCATION = 1
    }
}