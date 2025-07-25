package com.leandro1995.tinkuysabor.model.design

import android.app.Activity
import androidx.annotation.StringRes
import com.google.android.material.appbar.MaterialToolbar
import com.leandro1995.tinkuysabor.R

class Toolbar(
    private val activity: Activity,
    private val materialToolbar: MaterialToolbar,
    private var isBack: Boolean = false
) {

    fun config(@StringRes idTitle: Int, method: () -> Unit = {}) {
        materialToolbar.apply {
            title = activity.getString(idTitle)
            if (isBack) {
                setNavigationIcon(R.drawable.ic_arrow)
            }
            setNavigationOnClickListener {
                method()
            }
        }
    }
}