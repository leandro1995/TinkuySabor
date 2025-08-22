package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.intent.action.TourismListIntentAction
import com.leandro1995.tinkuysabor.intent.event.TourismListIntentEvent
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class TourismListViewModel() : ViewModelAmbient<TourismListIntentAction, TourismListIntentEvent>() {

    private fun tourismListLoading() {
        value(
            action = TourismListIntentAction(
                loading = Loading(
                    idService = TOURISM_LIST_LOADING, isVisible = true
                )
            )
        )
    }

    override fun intentAction(action: Int) {
        when (action) {
            TOURISM_LIST_LOADING -> {
                tourismListLoading()
            }
        }
    }

    override suspend fun startService(idService: Int) {
        when (idService) {
            TOURISM_LIST_FIREBASE -> {

            }
        }
    }

    companion object {
        const val TOURISM_LIST_LOADING = 0

        private const val TOURISM_LIST_FIREBASE = 1
    }
}