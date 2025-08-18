package com.leandro1995.tinkuysabor.model.design

import com.google.android.material.appbar.MaterialToolbar
import com.leandro1995.tinkuysabor.R

class Toolbar(
    private val materialToolbar: MaterialToolbar,
    private var isBack: Boolean = false,
    private val title: String
) {

    fun create(back: () -> Unit = {}) {
        materialToolbar.apply {
            title = this@Toolbar.title
            if (isBack) {
                setNavigationIcon(R.drawable.ic_arrow)
            }
            setNavigationOnClickListener {
                back()
            }
        }
    }
}