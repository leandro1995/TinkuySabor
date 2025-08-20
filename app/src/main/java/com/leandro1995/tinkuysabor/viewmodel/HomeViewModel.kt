package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class HomeViewModel : ViewModelAmbient<HomeIntentAction>() {
    private fun loadingLocationGone() {
        value(action = HomeIntentAction.LoadingLocationGone)
    }

    private fun verifyLocation() {
        value(action = HomeIntentAction.VerifyLocation)
    }

    private fun initView() {
        value(action = HomeIntentAction.InitView)
    }

    override fun intentAction(action: Int) {
        when (action) {
            INIT_VIEW -> {
                initView()
            }

            LOADING_LOCATION_GONE -> {
                loadingLocationGone()
            }

            VERIFY_LOCATION -> {
                verifyLocation()
            }
        }
    }

    companion object {
        const val INIT_VIEW = 0
        const val LOADING_LOCATION_GONE = 1
        const val VERIFY_LOCATION = 2
    }
}