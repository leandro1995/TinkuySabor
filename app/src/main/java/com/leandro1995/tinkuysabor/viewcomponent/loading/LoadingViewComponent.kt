package com.leandro1995.tinkuysabor.viewcomponent.loading

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.ViewComponentLoadingBinding
import com.leandro1995.tinkuysabor.viewcomponent.ambient.LoadingComponentAmbient

class LoadingViewComponent(context: Context, attrs: AttributeSet?) :
    LoadingComponentAmbient<ViewComponentLoadingBinding>(context = context, attrs = attrs) {

    init {
        initView(dataBinding = dataBinding(layoutId = R.layout.view_component_loading))
    }

    override fun initView(dataBinding: ViewComponentLoadingBinding) {

    }
}