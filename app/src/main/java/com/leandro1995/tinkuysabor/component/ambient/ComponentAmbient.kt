package com.leandro1995.tinkuysabor.component.ambient

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil

open class ComponentAmbient<VH> @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    protected fun dataBinding(@LayoutRes layoutId: Int) =
        DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, this, true) as VH

    protected open fun initView(dataBinding: VH) {}
}