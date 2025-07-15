package com.leandro1995.tinkuysabor.protodatastore.config

import android.content.Context
import androidx.datastore.core.DataStore
import com.leandro1995.tinkuysabor.UserProtoDataStore
import com.leandro1995.tinkuysabor.extension.userProtoDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object UserProtoDataStoreConfig {

    private lateinit var userProtoDataStore: DataStore<UserProtoDataStore>

    fun instance(context: Context) {
        userProtoDataStore = context.userProtoDataStore
    }

    fun setGiveName(giveName: String) = runBlocking {
        userProtoDataStore.updateData { userProtoDataStore ->
            userProtoDataStore.toBuilder().setGiveName(giveName).build()
        }
    }

    fun setFamilyName(familyName: String) = runBlocking {
        userProtoDataStore.updateData { userProtoDataStore ->
            userProtoDataStore.toBuilder().setFamilyName(familyName).build()
        }
    }

    fun setEmail(email: String) = runBlocking {
        userProtoDataStore.updateData { userProtoDataStore ->
            userProtoDataStore.toBuilder().setEmail(email).build()
        }
    }

    fun setPicture(picture: String) = runBlocking {
        userProtoDataStore.updateData { userProtoDataStore ->
            userProtoDataStore.toBuilder().setPicture(picture).build()
        }
    }

    fun getGiveName(): String = runBlocking { userProtoDataStore.data.first().giveName }

    fun getFamilyName(): String = runBlocking { userProtoDataStore.data.first().familyName }

    fun getEmail(): String = runBlocking { userProtoDataStore.data.first().email }

    fun getPicture(): String = runBlocking { userProtoDataStore.data.first().picture }
}