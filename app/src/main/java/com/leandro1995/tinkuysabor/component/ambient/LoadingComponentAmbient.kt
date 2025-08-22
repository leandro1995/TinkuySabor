package com.leandro1995.tinkuysabor.component.ambient

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.tinkuysabor.background.config.TimeType
import com.leandro1995.tinkuysabor.background.coroutine.TimerCoroutine
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.design.Message

open class LoadingComponentAmbient<VH>(context: Context, attrs: AttributeSet?) :
    ViewComponentAmbient<VH>(context = context, attrs = attrs) {

    fun start(loading: Loading, method: suspend () -> Unit) {
        if (loading.isStartService()) {
            if (loading.isVisible) {
                visible()
                TimerCoroutine(
                    timeType = TimeType.SECOND, time = TIME_OUT
                ).timeStart(method = method)
            } else {
                gone()
            }
        } else {
            gone()
        }
    }

    fun visibleLoading(isVisible: Boolean) {
        if (isVisible) {
            visible()
        } else {
            gone()
        }
    }

    open fun messageError(messageError: Message, buttonError: () -> Unit) {}

    protected open fun visible() {}

    protected open fun gone() {}

    protected open fun onClick() {}

    protected open fun instanceAmbientCallBack(buttonError: () -> Unit) {}

    companion object {
        private const val TIME_OUT = 2L
    }
}