package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.design.Message

class HomeIntentAction(
    val locationLoading: Loading = Loading(),
    val isVerifyLocation: Boolean = false,
    val isStartLocation: Boolean = false,
    val loading: Loading = Loading(),
    val tourMessageError: Message = Message()
)