package com.leandro1995.tinkuysabor.application

import android.app.Application
import com.leandro1995.tinkuysabor.protodatastore.config.UserProtoDataStoreConfig

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        UserProtoDataStoreConfig.instance(context = this)
    }
}