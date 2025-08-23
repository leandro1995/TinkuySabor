package com.leandro1995.tinkuysabor.intent.callback.ambient

interface IntentCallBackAmbient<T> {

    fun view(view: T)

    fun initView()
}