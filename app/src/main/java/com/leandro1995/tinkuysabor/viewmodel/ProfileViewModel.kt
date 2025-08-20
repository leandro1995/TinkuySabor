package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.activity.LoginActivity
import com.leandro1995.tinkuysabor.intent.action.ProfileIntentAction
import com.leandro1995.tinkuysabor.model.entity.User
import com.leandro1995.tinkuysabor.protodatastore.config.UserProtoDataStoreConfig
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class ProfileViewModel : ViewModelAmbient<ProfileIntentAction>() {

    val user = User(
        giveName = UserProtoDataStoreConfig.getGiveName(),
        familyName = UserProtoDataStoreConfig.getFamilyName(),
        email = UserProtoDataStoreConfig.getEmail(),
        picture = UserProtoDataStoreConfig.getPicture()
    )

    private fun loginActivity() {
        resetUserProtoDataStore()
        value(action = ProfileIntentAction.StartLoginActivity(loginActivity = LoginActivity()))
    }

    private fun resetUserProtoDataStore() {
        UserProtoDataStoreConfig.apply {
            setIdToken(idToken = "")
            setGiveName(giveName = "")
            setFamilyName(familyName = "")
            setEmail(email = "")
            setPicture(picture = "")
        }
    }

    private fun initView() {
        value(action = ProfileIntentAction.InitView)
    }

    override fun intentAction(action: Int) {
        when (action) {
            INIT_VIEW -> {
                initView()
            }

            LOGIN_ACTIVITY -> {
                loginActivity()
            }
        }
    }

    companion object {
        const val INIT_VIEW = 0
        const val LOGIN_ACTIVITY = 1
    }
}