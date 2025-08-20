package com.leandro1995.tinkuysabor.component.loading

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.component.ambient.LoadingComponentAmbient
import com.leandro1995.tinkuysabor.databinding.ViewComponentLoadingLocationBinding

class LocationLoadingViewComponent(context: Context, attrs: AttributeSet?) :
    LoadingComponentAmbient<ViewComponentLoadingLocationBinding>(context = context, attrs = attrs) {

    private lateinit var viewComponentLoadingLocationBinding: ViewComponentLoadingLocationBinding

    init {
        initView(dataBinding = dataBinding(layoutId = R.layout.view_component_loading_location))
    }

    override fun initView(dataBinding: ViewComponentLoadingLocationBinding) {
        viewComponentLoadingLocationBinding = dataBinding
        gone()
    }

    override fun gone() {
        viewComponentLoadingLocationBinding.loadingLinear.visibility = GONE
    }

    override fun visible() {
        viewComponentLoadingLocationBinding.loadingLinear.visibility = VISIBLE
    }
}