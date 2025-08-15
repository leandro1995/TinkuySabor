package com.leandro1995.tinkuysabor.intent.callback

import com.leandro1995.tinkuysabor.intent.callback.ambient.ServiceIntentCallBackAmbient
import com.leandro1995.tinkuysabor.model.entity.Tour

interface TourismListIntentCallBack : ServiceIntentCallBackAmbient {
    fun tourismArrayList(tourismArrayList: ArrayList<Tour>)
}