package com.leandro1995.tinkuysabor.extension

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.leandro1995.tinkuysabor.UserProtoDataStore
import com.leandro1995.tinkuysabor.config.Setting
import com.leandro1995.tinkuysabor.protodatastore.serializer.UserProtoDataStoreSerializer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun <T : ViewBinding> Activity.bindingUtil(@LayoutRes layoutId: Int) =
    DataBindingUtil.setContentView(this, layoutId) as T

fun <T : ViewBinding> bindingUtil(
    @LayoutRes layoutId: Int, inflater: LayoutInflater, container: ViewGroup?
) = DataBindingUtil.inflate(inflater, layoutId, container, false) as T

fun Activity.lifecycleScopeLaunch(method: suspend () -> Unit) {
    (this as AppCompatActivity).lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.CREATED) {
            method()
        }
    }
}

fun coroutineScope(context: CoroutineContext, method: suspend () -> Unit) {
    CoroutineScope(context).launch {
        method()
    }
}

val Context.userProtoDataStore: DataStore<UserProtoDataStore> by dataStore(
    Setting.DATA_STORE_FILE_NAME, UserProtoDataStoreSerializer()
)