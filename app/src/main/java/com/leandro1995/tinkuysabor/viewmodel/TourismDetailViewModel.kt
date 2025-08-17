package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.tinkuysabor.intent.action.TourismDetailIntentAction
import com.leandro1995.tinkuysabor.model.entity.Tour
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class TourismDetailViewModel : ViewModel() {
    val tourismDetailIntentAction: MutableSharedFlow<TourismDetailIntentAction> by lazy {
        MutableStateFlow(TourismDetailIntentAction.InitView)
    }

    var tour: Tour? = null
}