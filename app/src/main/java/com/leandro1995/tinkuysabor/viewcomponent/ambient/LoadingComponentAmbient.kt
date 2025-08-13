package com.leandro1995.tinkuysabor.viewcomponent.ambient

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.tinkuysabor.background.config.TimeType
import com.leandro1995.tinkuysabor.background.coroutine.TimerCoroutine
import kotlinx.coroutines.Dispatchers

open class LoadingComponentAmbient<VH>(context: Context, attrs: AttributeSet?) :
    ViewComponentAmbient<VH>(context = context, attrs = attrs) {

    fun start(method: () -> Unit) {
        visible()
        TimerCoroutine(
            dispatcher = Dispatchers.Main, timeType = TimeType.SECOND, time = TIME_OUT
        ).timeStart {
            method()
            gone()
        }
    }

    protected open fun visible() {}

    protected open fun gone() {}

    companion object {
        private const val TIME_OUT = 5L
    }
}