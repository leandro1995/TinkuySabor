package com.leandro1995.tinkuysabor.intent.config

import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import com.leandro1995.tinkuysabor.intent.callback.HomeIntentCallBack
import com.leandro1995.tinkuysabor.intent.config.ambient.IntentConfigAmbient

class HomeIntentConfig(
    private val homeIntentAction: HomeIntentAction?,
    private val homeIntentCallBack: HomeIntentCallBack?
) : IntentConfigAmbient() {

    init {
        instance()
    }

    override fun instance() {
        when (homeIntentAction) {
            HomeIntentAction.InitView -> {
                //homeIntentCallBack?.initView()
            }

            is HomeIntentAction.LoadingLocation -> {
                homeIntentCallBack?.loadingLocation(loading = homeIntentAction.loading)
            }

            HomeIntentAction.VerifyLocation -> {
                homeIntentCallBack?.verifyLocation()
            }

            HomeIntentAction.StartLocation -> {
                homeIntentCallBack?.startLocation()
            }

            is HomeIntentAction.AddMarkerPersonnelTourism -> {
                homeIntentCallBack?.addMarkerPersonnelTourism(
                    personalLatLng = homeIntentAction.personalLatLng,
                    tourismArrayList = homeIntentAction.tourismArrayList
                )
            }

            is HomeIntentAction.ServiceIntent -> {
                serviceIntentActionConfig(
                    serviceIntentActionConfig = homeIntentAction.serviceIntentActionConfig,
                    serviceIntentCallBackAmbient = homeIntentCallBack
                )
            }

            null -> {}
        }
    }
}