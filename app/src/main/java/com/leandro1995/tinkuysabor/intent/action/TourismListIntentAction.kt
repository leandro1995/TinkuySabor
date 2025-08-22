package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.design.Message
import com.leandro1995.tinkuysabor.model.entity.Tour

class TourismListIntentAction(
    val loading: Loading = Loading(),
    val tourArrayList: ArrayList<Tour> = arrayListOf(),
    val message: Message = Message()
)