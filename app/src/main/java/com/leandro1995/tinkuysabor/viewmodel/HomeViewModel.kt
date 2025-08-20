package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class HomeViewModel : ViewModelAmbient<HomeIntentAction>() {
    private fun initView() {
        value(action = HomeIntentAction.InitView)
    }

    private fun verifyLocation() {
        loading(isVisible = true)
    }

    private fun loading(isVisible: Boolean) {
        value(action = HomeIntentAction.LoadingLocation(loading = Loading(isVisible = isVisible)))
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