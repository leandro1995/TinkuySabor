package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.tinkuysabor.viewmodel.callback.ServiceViewModel
import com.leandro1995.tinkuysabor.intent.action.TourismListIntentAction
import com.leandro1995.tinkuysabor.intent.action.config.ServiceIntentActionConfig
import com.leandro1995.tinkuysabor.model.design.Loading
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.model.entity.User
import kotlinx.coroutines.flow.MutableStateFlow

class TourismListViewModel : ViewModel(), ServiceViewModel {
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
                }, errorMessage = {})
            }
        }
    }

    override fun loading(loading: Loading) {
        tourismListIntentAction.value = TourismListIntentAction.ShowLoading(
            serviceIntentActionConfig = ServiceIntentActionConfig.LoadingShow(loading = loading)
        )
    }

    companion object {
        const val TOURISM_LIST = 0
        const val TOURISM_LIST_SERVICE = 1
    }
}