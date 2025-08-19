package com.leandro1995.tinkuysabor.extension

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.google.android.gms.maps.SupportMapFragment
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

fun Fragment.viewLifecycleOwner(method: suspend () -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
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

@Suppress("DEPRECATION")
inline fun <reified T : Parcelable> String.putExtraParcelable(activity: Activity) =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        activity.intent.extras?.getParcelable(this, T::class.java)
    } else {
        activity.intent.extras?.getParcelable<T>(this)
    }

fun mapAsync(fragmentManager: FragmentManager, @IdRes idMap: Int) =
    fragmentManager.findFragmentById(idMap) as SupportMapFragment

fun Fragment.registerForActivityLocationResult(method: () -> Unit, methodError: () -> Unit = {}) =
    this.registerForActivityResult(
        ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            method()
        } else {
            methodError()
        }
    }

val Context.userProtoDataStore: DataStore<UserProtoDataStore> by dataStore(
    Setting.DATA_STORE_FILE_NAME, UserProtoDataStoreSerializer()
)