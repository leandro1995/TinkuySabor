package com.leandro1995.tinkuysabor.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.application
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.intent.action.TourismListIntentAction
import com.leandro1995.tinkuysabor.intent.action.config.ServiceIntentActionConfig
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.model.entity.User
import com.leandro1995.tinkuysabor.viewmodel.callback.ServiceViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class TourismListViewModel(application: Application) : AndroidViewModel(application),
    ServiceViewModel {
    val tourismListIntentAction: MutableStateFlow<TourismListIntentAction> by lazy {
        MutableStateFlow(TourismListIntentAction.InitView)
    }

    private val user = User()
    private val tourismArrayList = arrayListOf<Tour>()

    val action = fun(action: Int) {
        when (action) {
            TOURISM_LIST -> {
                tourismList()
            }
        }
    }

    fun initView() {
        if (tourismArrayList.isEmpty()) {
            action.invoke(TOURISM_LIST)
        } else {
            tourismArrayList(tourismArrayList = tourismArrayList)
        }
    }

    private fun tourismList() {
        loading(loading = Loading(idService = TOURISM_LIST_SERVICE, isVisible = true))
    }

    private fun tourismArrayList(tourismArrayList: ArrayList<Tour>) {
        tourismListIntentAction.value =
            TourismListIntentAction.TourismArrayList(tourismArrayList = tourismArrayList)
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
                    messageError(messageError = application.getString(R.string.error_message))
                })
            }
        }
    }

    override fun loading(loading: Loading) {
        tourismListIntentAction.value = TourismListIntentAction.ServiceIntent(
            serviceIntentActionConfig = ServiceIntentActionConfig.LoadingShow(loading = loading)
        )
    }

    override fun messageError(messageError: String) {
        tourismListIntentAction.value = TourismListIntentAction.ServiceIntent(
            serviceIntentActionConfig = ServiceIntentActionConfig.MessageError(messageError = messageError)
        )
    }

    companion object {
        const val TOURISM_LIST = 0
        const val TOURISM_LIST_SERVICE = 1
    }
}