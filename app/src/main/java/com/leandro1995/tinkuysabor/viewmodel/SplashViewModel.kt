package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.tinkuysabor.activity.HomeActivity
import com.leandro1995.tinkuysabor.activity.LoginActivity
import com.leandro1995.tinkuysabor.intent.event.SplashIntentEvent
import com.leandro1995.tinkuysabor.protodatastore.config.UserProtoDataStoreConfig
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient
import kotlinx.coroutines.flow.MutableStateFlow

class SplashViewModel : ViewModelAmbient<Any, SplashIntentEvent>() {

    private fun startActivity() {
        emit(
            event = SplashIntentEvent.StartActivity(
                activity = if (UserProtoDataStoreConfig.getIdToken().isEmpty()) {
                    LoginActivity()
                } else {
                    HomeActivity()
                }
            )
        )
    }

    override fun intentAction(action: Int) {
        when (action) {
            START_ACTIVITY -> {
                startActivity()
            }
        }
    }

    companion object {
        const val START_ACTIVITY = 0
    }
}