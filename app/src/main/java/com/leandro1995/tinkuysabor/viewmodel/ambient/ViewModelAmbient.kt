package com.leandro1995.tinkuysabor.viewmodel.ambient

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking

open class ViewModelAmbient<A : Any, E : Any>() : ViewModel() {

    private val intentActionMutableStateFlow: MutableStateFlow<A?> by lazy {
        MutableStateFlow(null)
    }

    val intentActionStateFlow = intentActionMutableStateFlow.asStateFlow()

    private val intentEventMutableSharedFlow: MutableSharedFlow<E> by lazy {
        MutableSharedFlow()
    }

    val intentEventSharedFlow = intentEventMutableSharedFlow.asSharedFlow()

    val action = fun(action: Int) {
        intentAction(action = action)
    }

    fun value(action: A) {
        intentActionMutableStateFlow.value = action
    }

    fun emit(event: E) = runBlocking { intentEventMutableSharedFlow.emit(event) }

    protected open fun intentAction(action: Int) {}

    open suspend fun startService(idService: Int) {}
}