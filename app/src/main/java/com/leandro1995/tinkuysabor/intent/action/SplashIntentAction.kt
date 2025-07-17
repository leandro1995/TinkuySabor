package com.leandro1995.tinkuysabor.intent.action

import android.app.Activity

sealed class SplashIntentAction {
    data object InitView : SplashIntentAction()
    data class ViewActivity(val activity: Activity) : SplashIntentAction()
}