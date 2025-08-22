package com.leandro1995.tinkuysabor.intent.callback

import com.google.android.gms.maps.model.LatLng
import com.leandro1995.tinkuysabor.intent.callback.ambient.IntentCallBackAmbient
import com.leandro1995.tinkuysabor.intent.callback.ambient.ServiceIntentCallBackAmbient
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.entity.Tour

interface HomeIntentCallBack :  ServiceIntentCallBackAmbient {
    fun loadingLocation(loading: Loading)
    fun verifyLocation()
    fun startLocation()
    fun addMarkerPersonnelTourism(personalLatLng: LatLng, tourismArrayList: ArrayList<Tour>)
}