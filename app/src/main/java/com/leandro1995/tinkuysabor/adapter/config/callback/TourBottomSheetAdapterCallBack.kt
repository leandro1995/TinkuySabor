package com.leandro1995.tinkuysabor.adapter.config.callback

import com.google.android.gms.maps.model.LatLng
import com.leandro1995.tinkuysabor.model.entity.Tour

interface TourBottomSheetAdapterCallBack {
    fun animateCamera(latLng: LatLng)
    fun tourDetail(tour: Tour)
}