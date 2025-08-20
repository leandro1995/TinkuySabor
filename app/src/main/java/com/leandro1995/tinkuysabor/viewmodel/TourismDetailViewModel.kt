package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.intent.action.TourismDetailIntentAction
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class TourismDetailViewModel : ViewModelAmbient<TourismDetailIntentAction>() {

    var tour: Tour? = null

    override fun intentAction(action: Int) {
        when (action) {
            INIT_VIEW -> {
                initView()
            }
        }
    }

    private fun initView() {
        value(action = TourismDetailIntentAction.InitView, isDefaultValue = false)
    }

    companion object {
        const val INIT_VIEW = 0
    }
}