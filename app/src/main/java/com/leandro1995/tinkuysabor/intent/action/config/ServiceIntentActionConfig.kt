package com.leandro1995.tinkuysabor.intent.action.config

import androidx.annotation.StringRes
import com.leandro1995.tinkuysabor.model.design.Loading

sealed class ServiceIntentActionConfig {
    data class LoadingShow(val loading: Loading) : ServiceIntentActionConfig()
    data class MessageError(@param:StringRes val idMessageError: Int) : ServiceIntentActionConfig()
}