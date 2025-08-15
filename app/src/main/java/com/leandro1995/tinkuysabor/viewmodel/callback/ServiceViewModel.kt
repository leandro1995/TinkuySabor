package com.leandro1995.tinkuysabor.viewmodel.callback

import com.leandro1995.tinkuysabor.model.design.Loading

interface ServiceViewModel {
    fun startService(idService: Int)
    fun loading(loading: Loading)
}