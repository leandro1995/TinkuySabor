package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class HomeViewModel : ViewModelAmbient<HomeIntentAction>() {
    private fun initView() {
        value(action = HomeIntentAction.InitView)
    }

    override fun intentAction(action: Int) {
        when (action) {
            INIT_VIEW -> {
                initView()
            }
        }
    }

    companion object {
        const val INIT_VIEW = 0
    }
}