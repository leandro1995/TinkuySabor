package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.tinkuysabor.activity.LoginActivity
import com.leandro1995.tinkuysabor.intent.action.ProfileIntentAction
import com.leandro1995.tinkuysabor.model.entity.User
import com.leandro1995.tinkuysabor.protodatastore.config.UserProtoDataStoreConfig
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel : ViewModel() {

    val profileIntentAction: MutableStateFlow<ProfileIntentAction> by lazy {
        MutableStateFlow(ProfileIntentAction.InitView)
    }

    val user = User(
        giveName = UserProtoDataStoreConfig.getGiveName(),
        familyName = UserProtoDataStoreConfig.getFamilyName(),
        email = UserProtoDataStoreConfig.getEmail(),
        picture = UserProtoDataStoreConfig.getPicture()
    )

    val action = fun(action: Int) {
        when (action) {
            LOGIN_ACTIVITY -> {
                loginActivity()
            }
        }
    }

    private fun loginActivity() {
        resetUserProtoDataStore()
        profileIntentAction.value =
            ProfileIntentAction.StartLoginActivity(loginActivity = LoginActivity())
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

    companion object {
        const val LOGIN_ACTIVITY = 0
    }
}