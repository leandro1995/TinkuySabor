package com.leandro1995.tinkuysabor.viewmodel

import com.google.android.gms.maps.model.LatLng
import com.leandro1995.tinkuysabor.background.config.TimeType
import com.leandro1995.tinkuysabor.background.coroutine.TimerCoroutine
import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient
import com.leandro1995.tinkuysabor.viewmodel.callback.ServiceViewModel
import kotlinx.coroutines.Dispatchers

class HomeViewModel : ViewModelAmbient<HomeIntentAction>(), ServiceViewModel {

    lateinit var latLng: LatLng

    private fun initView() {
        value(action = HomeIntentAction.InitView)
    }

    private fun verifyLocation() {
        value(action = HomeIntentAction.VerifyLocation)
    }

    private fun startLocation() {
        loading(isVisible = true)
        TimerCoroutine(
            dispatcher = Dispatchers.Main, timeType = TimeType.SECOND, time = START_LOCATION_TIME
        ).timeStart {
            value(action = HomeIntentAction.StartLocation)
        }
    }

    private fun tourismList() {
        loading(isVisible = false)
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

            START_LOCATION -> {
                startLocation()
            }

            TOURISM_LIST -> {
                tourismList()
            }
        }
    }

    override fun startService(idService: Int) {

    }

    override fun loading(loading: Loading) {

    }

    override fun messageError(idMessageError: Int) {

    }

    companion object {
        const val INIT_VIEW = 0
        const val VERIFY_LOCATION = 1
        const val START_LOCATION = 2
        const val TOURISM_LIST = 3

        private const val START_LOCATION_TIME = 1L
    }
}