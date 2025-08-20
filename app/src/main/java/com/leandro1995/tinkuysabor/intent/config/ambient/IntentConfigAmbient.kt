package com.leandro1995.tinkuysabor.intent.config.ambient

import com.leandro1995.tinkuysabor.intent.action.config.ServiceIntentActionConfig
import com.leandro1995.tinkuysabor.intent.callback.ambient.ServiceIntentCallBackAmbient

abstract class IntentConfigAmbient {

    protected open fun instance() {}

    protected open fun serviceIntentActionConfig(
        serviceIntentActionConfig: ServiceIntentActionConfig,
        serviceIntentCallBackAmbient: ServiceIntentCallBackAmbient?
    ) {
        when (serviceIntentActionConfig) {
            is ServiceIntentActionConfig.LoadingShow -> {
                serviceIntentCallBackAmbient?.showLoading(loading = serviceIntentActionConfig.loading)
            }

            is ServiceIntentActionConfig.MessageError -> {
                serviceIntentCallBackAmbient?.messageError(idMessageError = serviceIntentActionConfig.idMessageError)
            }
        }
    }
}