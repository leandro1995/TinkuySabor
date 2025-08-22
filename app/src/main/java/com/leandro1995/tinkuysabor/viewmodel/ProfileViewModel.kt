package com.leandro1995.tinkuysabor.viewmodel

import com.leandro1995.tinkuysabor.intent.event.ProfileIntentEvent
import com.leandro1995.tinkuysabor.model.entity.User
import com.leandro1995.tinkuysabor.protodatastore.config.UserProtoDataStoreConfig
import com.leandro1995.tinkuysabor.viewmodel.ambient.ViewModelAmbient

class ProfileViewModel : ViewModelAmbient<Any, ProfileIntentEvent>() {

    val user = User(
        giveName = UserProtoDataStoreConfig.getGiveName(),
        familyName = UserProtoDataStoreConfig.getFamilyName(),
        email = UserProtoDataStoreConfig.getEmail(),
        picture = UserProtoDataStoreConfig.getPicture()
    )

    private fun loginActivity() {
        resetUserProtoDataStore()
        emit(event = ProfileIntentEvent.StartLoginActivity)
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

    override fun intentAction(action: Int) {
        when (action) {
            LOGIN_ACTIVITY -> {
                loginActivity()
            }
        }
    }

    companion object {
        const val LOGIN_ACTIVITY = 0
    }
}