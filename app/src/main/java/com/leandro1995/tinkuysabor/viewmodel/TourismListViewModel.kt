package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.intent.action.TourismListIntentAction
import com.leandro1995.tinkuysabor.intent.action.config.ServiceIntentActionConfig
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.model.entity.User
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient
import com.leandro1995.tinkuysabor.viewmodel.callback.ServiceViewModel

class TourismListViewModel : ViewModelAmbient<TourismListIntentAction, Any>(), ServiceViewModel {
    private val user = User()
    private val tourismArrayList = arrayListOf<Tour>()

    private fun initView() {
        value(action = TourismListIntentAction.InitView)
    }

    private fun tourismList() {
        if (tourismArrayList.isEmpty()) {
            loading(loading = Loading(idService = TOURISM_LIST_SERVICE, isVisible = true))
        } else {
            tourismArrayList(tourismArrayList = tourismArrayList)
        }
    }

    private fun tourismArrayList(tourismArrayList: ArrayList<Tour>) {
        value(action = TourismListIntentAction.TourismArrayList(tourismArrayList = tourismArrayList))
    }

    override fun startService(idService: Int) {
        when (idService) {
            TOURISM_LIST_SERVICE -> {
                user.tourismList(tourArrayListSuccess = {
                    tourismArrayList.clear()
                    tourismArrayList.addAll(it)

                    tourismArrayList(tourismArrayList = tourismArrayList)
                    loading(loading = Loading(isVisible = false))
                }, errorMessage = {
                    messageError(idMessageError = R.string.error_message)
                })
            }
        }
    }

    override fun loading(loading: Loading) {
        value(
            action = TourismListIntentAction.ServiceIntent(
                serviceIntentActionConfig = ServiceIntentActionConfig.LoadingShow(loading = loading)
            )
        )
    }

    override fun messageError(idMessageError: Int) {
        value(
            action = TourismListIntentAction.ServiceIntent(
                serviceIntentActionConfig = ServiceIntentActionConfig.MessageError(idMessageError = idMessageError)
            )
        )
    }

    override fun intentAction(action: Int) {
        when (action) {
            INIT_VIEW -> {
                initView()
            }

            TOURISM_LIST -> {
                tourismList()
            }
        }
    }

    companion object {
        const val INIT_VIEW = 0
        const val TOURISM_LIST = 1
        private const val TOURISM_LIST_SERVICE = 2
    }
}