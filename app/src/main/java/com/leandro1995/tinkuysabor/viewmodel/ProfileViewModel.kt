package com.leandro1995.tinkuysabor.viewmodel

import androidx.lifecycle.ViewModel
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
        familyName = UserProtoDataStoreConfig.getGiveName(),
        email = UserProtoDataStoreConfig.getEmail(),
        picture = UserProtoDataStoreConfig.getPicture()
    )
}