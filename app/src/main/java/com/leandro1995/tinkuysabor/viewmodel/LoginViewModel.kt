package com.leandro1995.tinkuysabor.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.application
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.leandro1995.tinkuysabor.activity.HomeActivity
import com.leandro1995.tinkuysabor.fcm.authentication.FCMGoogleAuthentication
import com.leandro1995.tinkuysabor.fcm.login.FCMGoogleLogin
import com.leandro1995.tinkuysabor.intent.action.LoginIntentAction
import com.leandro1995.tinkuysabor.model.entity.User
import com.leandro1995.tinkuysabor.protodatastore.config.UserProtoDataStoreConfig
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val loginIntentAction: MutableStateFlow<LoginIntentAction> by lazy {
        MutableStateFlow(LoginIntentAction.InitView)
    }

    private var idToken = ""
    private val user = User()

    val action = fun(action: Int) {
        when (action) {
            GOOGLE_LOGIN -> {
                googleLogin()
            }

            GOOGLE_AUTHENTICATION -> {
                googleAuthentication()
            }

            SAVE_PROTO_DATA_STORE -> {
                saveProtoDatabaseStore()
            }

            START_HOME_ACTIVITY -> {
                startHomeActivity()
            }
        }
    }

    fun saveUserProtoDataStore(googleIdTokenCredential: GoogleIdTokenCredential) {
        idToken = googleIdTokenCredential.idToken

        user.let {
            it.giveName = googleIdTokenCredential.givenName.orEmpty()
            it.familyName = googleIdTokenCredential.familyName.orEmpty()
            it.email = googleIdTokenCredential.id
            it.picture = googleIdTokenCredential.profilePictureUri?.path.orEmpty()
        }
    }

    private fun googleLogin() {
        loginIntentAction.value =
            LoginIntentAction.GoogleLogin(fcmGoogleLogin = FCMGoogleLogin(application = application))
    }

    private fun googleAuthentication() {
        loginIntentAction.value = LoginIntentAction.GoogleAuthentication(
            fcmGoogleAuthentication = FCMGoogleAuthentication(
                googleToken = idToken
            )
        )
    }

    private fun saveProtoDatabaseStore() {
        user.let {
            UserProtoDataStoreConfig.setGiveName(giveName = it.giveName)
            UserProtoDataStoreConfig.setFamilyName(familyName = it.familyName)
            UserProtoDataStoreConfig.setEmail(email = it.email)
            UserProtoDataStoreConfig.setPicture(picture = it.picture)
        }

        action.invoke(START_HOME_ACTIVITY)
    }

    private fun startHomeActivity() {
        loginIntentAction.value = LoginIntentAction.StartHomeActivity(homeActivity = HomeActivity())
    }

    companion object {
        const val GOOGLE_LOGIN = 0
        const val GOOGLE_AUTHENTICATION = 1
        const val SAVE_PROTO_DATA_STORE = 2

        private const val START_HOME_ACTIVITY = 3
    }
}