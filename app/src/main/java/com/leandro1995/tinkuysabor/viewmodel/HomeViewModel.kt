package com.leandro1995.tinkuysabor.viewmodel

import com.google.android.gms.maps.model.LatLng
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.background.config.TimeType
import com.leandro1995.tinkuysabor.background.coroutine.TimerCoroutine
import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.intent.action.config.ServiceIntentActionConfig
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.model.entity.User
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient
import com.leandro1995.tinkuysabor.viewmodel.callback.ServiceViewModel
import kotlinx.coroutines.Dispatchers

class HomeViewModel : ViewModelAmbient<HomeIntentAction>(), ServiceViewModel {

    private val user = User()
    private val tourismArrayList = arrayListOf<Tour>()
    private var isTourism = false

    var personalLatLng: LatLng? = null

    private fun initView() {
        value(action = HomeIntentAction.InitView)
    }

    private fun verifyLocation() {
        if (personalLatLng == null) {
            value(action = HomeIntentAction.VerifyLocation)
        } else {
            action.invoke(TOURISM_LIST)
        }
    }

    private fun startLocation() {
        loadingVisible(isVisible = true)
        TimerCoroutine(
            dispatcher = Dispatchers.Main, timeType = TimeType.SECOND, time = START_LOCATION_TIME
        ).timeStart {
            value(action = HomeIntentAction.StartLocation)
        }
    }

    private fun tourismList() {
        if (isTourism) {
            value(
                action = HomeIntentAction.AddMarkerPersonnelTourism(
                    personalLatLng = personalLatLng!!, tourismArrayList = tourismArrayList
                )
            )
        } else {
            loadingVisible(isVisible = false)
            loading(loading = Loading(idService = TOURISM_LIST_SERVICE, isVisible = true))
        }
    }

    private fun loadingVisible(isVisible: Boolean) {
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
        when (idService) {
            TOURISM_LIST_SERVICE -> {
                user.tourismList(tourArrayListSuccess = {
                    tourismArrayList.clear()
                    tourismArrayList.addAll(it)
                    value(
                        action = HomeIntentAction.AddMarkerPersonnelTourism(
                            personalLatLng = personalLatLng!!, tourismArrayList = tourismArrayList
                        )
                    )
                    isTourism = true
                    loading(loading = Loading(isVisible = false))
                }, errorMessage = {
                    messageError(idMessageError = R.string.error_message)
                })
            }
        }
    }

    override fun loading(loading: Loading) {
        value(
            action = HomeIntentAction.ServiceIntent(
                serviceIntentActionConfig = ServiceIntentActionConfig.LoadingShow(
                    loading = loading
                )
            )
        )
    }

    override fun messageError(idMessageError: Int) {
        value(
            action = HomeIntentAction.ServiceIntent(
                serviceIntentActionConfig = ServiceIntentActionConfig.MessageError(
                    idMessageError = idMessageError
                )
            )
        )
    }

    companion object {
        const val INIT_VIEW = 0
        const val VERIFY_LOCATION = 1
        const val START_LOCATION = 2
        const val TOURISM_LIST = 3

        private const val TOURISM_LIST_SERVICE = 4

        private const val START_LOCATION_TIME = 1L
    }
}