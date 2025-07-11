package com.leandro1995.tinkuysabor.extension

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> Activity.bindingUtil(@LayoutRes layoutId: Int) =
    DataBindingUtil.setContentView(this, layoutId) as T