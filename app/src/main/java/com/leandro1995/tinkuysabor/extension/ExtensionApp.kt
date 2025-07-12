package com.leandro1995.tinkuysabor.extension

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun <T : ViewBinding> Activity.bindingUtil(@LayoutRes layoutId: Int) =
    DataBindingUtil.setContentView(this, layoutId) as T

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