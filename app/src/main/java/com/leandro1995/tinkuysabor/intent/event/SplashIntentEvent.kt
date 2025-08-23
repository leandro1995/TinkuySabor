package com.leandro1995.tinkuysabor.intent.event

import android.app.Activity

sealed class SplashIntentEvent {

    data class StartActivity(val activity: Activity) : SplashIntentEvent()
}