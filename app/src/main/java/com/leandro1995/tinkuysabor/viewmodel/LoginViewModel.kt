package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.tinkuysabor.intent.action.LoginIntentAction
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel() {

    val loginIntentAction: MutableStateFlow<LoginIntentAction> by lazy {
        MutableStateFlow(LoginIntentAction.InitView)
    }
}