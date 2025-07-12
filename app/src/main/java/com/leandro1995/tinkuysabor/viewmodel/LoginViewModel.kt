package com.leandro1995.tinkuysabor.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.application
import com.leandro1995.tinkuysabor.fcm.login.FCMGoogleLogin
import com.leandro1995.tinkuysabor.intent.action.LoginIntentAction
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val loginIntentAction: MutableStateFlow<LoginIntentAction> by lazy {
        MutableStateFlow(LoginIntentAction.InitView)
    }

    val action = fun(action: Int) {
        when (action) {
            GOOGLE_LOGIN -> {
                googleLogin()
            }
        }
    }

    private fun googleLogin() {
        loginIntentAction.value =
            LoginIntentAction.GoogleLogin(fcmGoogleLogin = FCMGoogleLogin(application = application))
    }

    companion object {
        const val GOOGLE_LOGIN = 0
    }
}