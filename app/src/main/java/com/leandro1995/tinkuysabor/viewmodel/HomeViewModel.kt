package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class HomeViewModel : ViewModelAmbient<HomeIntentAction, Any>() {

    private fun verifyGpsLocation() {
        value(action = HomeIntentAction(isVerifyLocation = true))
    }

    override fun intentAction(action: Int) {
        when (action) {
            VERIFY_GPS_LOCATION -> {
                verifyGpsLocation()
            }
        }
    }

    companion object {
        const val VERIFY_GPS_LOCATION = 0
    }
}