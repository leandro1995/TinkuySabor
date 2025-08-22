package com.leandro1995.tinkuysabor.viewmodel

import com.google.android.gms.maps.model.LatLng
import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class HomeViewModel : ViewModelAmbient<HomeIntentAction, Any>() {

    private lateinit var personLocation: LatLng

    fun personLocation(latLng: LatLng) {
        personLocation = latLng
    }

    private fun verifyGpsLocation() {
        value(action = HomeIntentAction(isVerifyLocation = true))
    }

    private fun gpsLocation() {
        value(
            action = HomeIntentAction(
                locationLoading = Loading(isVisible = true), isStartLocation = true
            )
        )
    }

    override fun intentAction(action: Int) {
        when (action) {
            VERIFY_GPS_LOCATION -> {
                verifyGpsLocation()
            }

            GPS_LOCATION -> {
                gpsLocation()
            }
        }
    }

    companion object {
        const val VERIFY_GPS_LOCATION = 0
        const val GPS_LOCATION = 1
    }
}