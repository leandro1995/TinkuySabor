package com.leandro1995.tinkuysabor.intent.action.config

import com.leandro1995.tinkuysabor.model.design.Loading

sealed class ServiceIntentActionConfig {
    data class LoadingShow(val loading: Loading) : ServiceIntentActionConfig()
}