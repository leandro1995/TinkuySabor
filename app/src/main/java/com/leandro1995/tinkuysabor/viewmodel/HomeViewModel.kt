package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.tinkuysabor.intent.action.HomeIntentAction
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel : ViewModel() {
    val homeIntentAction: MutableSharedFlow<HomeIntentAction> by lazy {
        MutableStateFlow(HomeIntentAction.InitView)
    }
}