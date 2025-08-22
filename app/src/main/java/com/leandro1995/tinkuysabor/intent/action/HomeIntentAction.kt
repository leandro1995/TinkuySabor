package com.leandro1995.tinkuysabor.intent.action

import com.leandro1995.tinkuysabor.model.design.Loading

class HomeIntentAction(
    val locationLoading: Loading = Loading(),
    val isVerifyLocation: Boolean = false,
    val isStartLocation: Boolean = false
)