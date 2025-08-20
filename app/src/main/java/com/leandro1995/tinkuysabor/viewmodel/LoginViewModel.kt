package com.leandro1995.tinkuysabor.viewmodel

import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.leandro1995.tinkuysabor.activity.HomeActivity
import com.leandro1995.tinkuysabor.fcm.authentication.GoogleFCMAuthentication
import com.leandro1995.tinkuysabor.fcm.login.GoogleFCMLogin
import com.leandro1995.tinkuysabor.intent.action.LoginIntentAction
import com.leandro1995.tinkuysabor.model.entity.User
import com.leandro1995.tinkuysabor.protodatastore.config.UserProtoDataStoreConfig
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class LoginViewModel : ViewModelAmbient<LoginIntentAction>() {

    private var idToken = ""
    private val user = User()

    fun saveUserProtoDataStore(googleIdTokenCredential: GoogleIdTokenCredential) {
        idToken = googleIdTokenCredential.idToken

        user.let {
            it.giveName = googleIdTokenCredential.givenName.orEmpty()
            it.familyName = googleIdTokenCredential.familyName.orEmpty()
            it.email = googleIdTokenCredential.id
            it.picture = googleIdTokenCredential.profilePictureUri.toString()
        }
    }

    private fun googleLogin() {
        value(action = LoginIntentAction.GoogleLogin(googleFCMLogin = GoogleFCMLogin()))
    }

    private fun googleAuthentication() {
        value(
            action = LoginIntentAction.GoogleAuthentication(
                googleFCMAuthentication = GoogleFCMAuthentication(
                    googleToken = idToken
                )
            )
        )
    }

    private fun saveProtoDatabaseStore() {
        UserProtoDataStoreConfig.setIdToken(idToken = idToken)
        user.let {
            UserProtoDataStoreConfig.setGiveName(giveName = it.giveName)
            UserProtoDataStoreConfig.setFamilyName(familyName = it.familyName)
            UserProtoDataStoreConfig.setEmail(email = it.email)
            UserProtoDataStoreConfig.setPicture(picture = it.picture)
        }

        action.invoke(START_HOME_ACTIVITY)
    }

    private fun startHomeActivity() {
        value(action = LoginIntentAction.StartHomeActivity(homeActivity = HomeActivity()))
    }

    private fun initView() {
        value(action = LoginIntentAction.InitView, isDefaultValue = false)
    }

    override fun intentAction(action: Int) {
        when (action) {
            INIT_VIEW -> {
                initView()
            }

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

    companion object {
        const val INIT_VIEW = 0
        const val GOOGLE_LOGIN = 1
        const val GOOGLE_AUTHENTICATION = 2
        const val SAVE_PROTO_DATA_STORE = 3

        private const val START_HOME_ACTIVITY = 4
    }
}