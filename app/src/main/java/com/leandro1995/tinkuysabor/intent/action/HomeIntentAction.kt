package com.leandro1995.tinkuysabor.intent.action

import com.google.android.gms.maps.model.LatLng
import com.leandro1995.tinkuysabor.intent.action.config.ServiceIntentActionConfig
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.entity.Tour

sealed class HomeIntentAction {
    data object InitView : HomeIntentAction()
    data object VerifyLocation : HomeIntentAction()
    data object StartLocation : HomeIntentAction()
    data class LoadingLocation(val loading: Loading) : HomeIntentAction()
    data class ServiceIntent(val serviceIntentActionConfig: ServiceIntentActionConfig) :
        HomeIntentAction()

    data class AddMarkerPersonnelTourism(
        val personalLatLng: LatLng, val tourismArrayList: ArrayList<Tour>
    ) : HomeIntentAction()
}