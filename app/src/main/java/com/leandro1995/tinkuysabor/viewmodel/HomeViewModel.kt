package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel : ViewModel() {
    val homeIntentAction: MutableStateFlow<HomeIntentAction> by lazy {
        MutableStateFlow(HomeIntentAction.InitView)
    }

    val action = fun(action: Int) {
        when (action) {
            LOADING_LOCATION_GONE -> {
                loadingLocationGone()
            }

            VERIFY_LOCATION -> {
                verifyLocation()
            }
        }
    }

    private fun loadingLocationGone() {
        homeIntentAction.value = HomeIntentAction.LoadingLocationGone
    }

    private fun verifyLocation() {
        homeIntentAction.value = HomeIntentAction.VerifyLocation
    }

    companion object {
        const val LOADING_LOCATION_GONE = 0
        const val VERIFY_LOCATION = 1
    }
}