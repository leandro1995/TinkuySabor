package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.tinkuysabor.intent.action.TourismListIntentAction
import kotlinx.coroutines.flow.MutableStateFlow

class TourismListViewModel : ViewModel() {
    val tourismListIntentAction: MutableStateFlow<TourismListIntentAction> by lazy {
        MutableStateFlow(TourismListIntentAction.InitView)
    }
}