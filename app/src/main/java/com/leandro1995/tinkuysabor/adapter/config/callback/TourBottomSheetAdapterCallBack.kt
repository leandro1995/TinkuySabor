package com.leandro1995.tinkuysabor.adapter.config.callback

import com.google.android.gms.maps.model.LatLng

interface TourBottomSheetAdapterCallBack {
    fun animateCamera(latLng: LatLng)
}