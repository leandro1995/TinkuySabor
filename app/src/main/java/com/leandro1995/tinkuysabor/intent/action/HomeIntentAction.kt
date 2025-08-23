package com.leandro1995.tinkuysabor.intent.action

import com.google.android.gms.maps.model.LatLng
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.design.Message
import com.leandro1995.tinkuysabor.model.entity.Tour

class HomeIntentAction(
    val locationLoading: Loading = Loading(),
    val isVerifyLocation: Boolean = false,
    val isStartLocation: Boolean = false,
    val loading: Loading = Loading(),
    val tourMessageError: Message = Message(),
    val personLocation: LatLng = LatLng(0.0, 0.0),
    val tourArrayList: ArrayList<Tour> = arrayListOf()
)