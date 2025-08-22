package com.leandro1995.tinkuysabor.model.design

class Loading(val idService: Int = -1, val isVisible: Boolean = false) {

    fun isStartService() = idService != -1
}