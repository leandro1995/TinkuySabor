package com.leandro1995.tinkuysabor.viewmodel.ambient

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class ViewModelAmbient<A : Any>() : ViewModel() {

    private val intentActionMutableStateFlow: MutableStateFlow<A?> by lazy {
        MutableStateFlow(null)
    }

    val intentActionStateFlow = intentActionMutableStateFlow.asStateFlow()

    val action = fun(action: Int) {
        intentAction(action = action)
    }

    fun value(action: A) {
        intentActionMutableStateFlow.value = action
    }

    protected open fun intentAction(action: Int) {}
}