package com.leandro1995.tinkuysabor.viewmodel.ambient

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

open class ViewModelAmbient<T> : ViewModel() {

    val intentActionMutableStateFlow: MutableStateFlow<T?> by lazy {
        MutableStateFlow(null)
    }

    val action = fun(action: Int) {
        intentAction(action = action)
    }

    fun value(action: T) {
        intentActionMutableStateFlow.value = action
    }

    protected open fun intentAction(action: Int) {}
}