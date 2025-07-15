package com.leandro1995.tinkuysabor.protodatastore.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.leandro1995.tinkuysabor.UserProtoDataStore
import java.io.InputStream
import java.io.OutputStream

class UserProtoDataStoreSerializer : Serializer<UserProtoDataStore> {

    override val defaultValue: UserProtoDataStore = UserProtoDataStore.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserProtoDataStore {
        try {
            return UserProtoDataStore.parseFrom(input)
        } catch (_: InvalidProtocolBufferException) {
            throw CorruptionException("")
        }
    }

    override suspend fun writeTo(t: UserProtoDataStore, output: OutputStream) = t.writeTo(output)
}