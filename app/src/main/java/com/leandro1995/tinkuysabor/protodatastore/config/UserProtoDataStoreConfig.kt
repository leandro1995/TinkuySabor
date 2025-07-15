package com.leandro1995.tinkuysabor.protodatastore.config

import android.content.Context
import androidx.datastore.core.DataStore
import com.leandro1995.tinkuysabor.UserProtoDataStore
import com.leandro1995.tinkuysabor.extension.userProtoDataStore

object UserProtoDataStoreConfig {

    private lateinit var userProtoDataStore: DataStore<UserProtoDataStore>

    fun instance(context: Context) {
        userProtoDataStore = context.userProtoDataStore
    }
}