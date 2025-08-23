package com.leandro1995.tinkuysabor.viewmodel

import com.google.android.gms.maps.model.LatLng
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.design.Message
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.model.entity.User
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class HomeViewModel : ViewModelAmbient<HomeIntentAction, Any>() {

    private lateinit var personLocation: LatLng
    private val user = User()
    private val tourArrayList: ArrayList<Tour> = arrayListOf()

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

    private fun tourismListLoading() {
        value(
            action = HomeIntentAction(
                loading = Loading(
                    idService = TOURISM_LIST_FIREBASE, isVisible = true
                )
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

            TOURISM_LIST_LOADING -> {
                tourismListLoading()
            }
        }
    }

    override suspend fun startService(idService: Int) {
        when (idService) {
            TOURISM_LIST_FIREBASE -> {
                user.tourismList(tourArrayListSuccess = {
                    tourArrayList.clear()
                    tourArrayList.addAll(it)
                    value(
                        action = HomeIntentAction(
                            personLocation = personLocation,
                            tourArrayList = tourArrayList,
                            isTourRouteBottomSheet = true
                        )
                    )
                }, messageError = {
                    value(action = HomeIntentAction(tourMessageError = Message(descriptionStringRes = R.string.error_message)))
                })
            }
        }
    }

    companion object {
        const val VERIFY_GPS_LOCATION = 0
        const val GPS_LOCATION = 1
        const val TOURISM_LIST_LOADING = 2

        private const val TOURISM_LIST_FIREBASE = 1
    }
}