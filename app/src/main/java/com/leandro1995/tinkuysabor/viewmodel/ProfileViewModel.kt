package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.tinkuysabor.intent.action.ProfileIntentAction
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel : ViewModel() {

    val profileIntentAction: MutableStateFlow<ProfileIntentAction> by lazy {
        MutableStateFlow(ProfileIntentAction.InitView)
    }
}