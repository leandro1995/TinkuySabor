package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.tinkuysabor.activity.HomeActivity
import com.leandro1995.tinkuysabor.activity.LoginActivity
import com.leandro1995.tinkuysabor.intent.action.SplashIntentAction
import com.leandro1995.tinkuysabor.protodatastore.config.UserProtoDataStoreConfig
import kotlinx.coroutines.flow.MutableStateFlow

class SplashViewModel : ViewModel() {
    val splashIntentAction: MutableStateFlow<SplashIntentAction> by lazy {
        MutableStateFlow(SplashIntentAction.InitView)
    }

    val action = fun(action: Int) {
        when (action) {
            VIEW_ACTIVITY -> {
                viewActivity()
            }
        }
    }

    private fun viewActivity() {
        splashIntentAction.value = SplashIntentAction.ViewActivity(activity = activity())
    }

    private fun activity() = if (UserProtoDataStoreConfig.getIdToken().isEmpty()) {
        LoginActivity()
    } else {
        HomeActivity()
    }

    companion object {
        const val VIEW_ACTIVITY = 0
    }
}