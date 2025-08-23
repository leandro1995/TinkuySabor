package com.leandro1995.tinkuysabor.component.loading

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.component.ambient.LoadingComponentAmbient
import com.leandro1995.tinkuysabor.databinding.ComponentLoadingLocationBinding

class LocationLoadingComponent(context: Context, attrs: AttributeSet?) :
    LoadingComponentAmbient<ComponentLoadingLocationBinding>(context = context, attrs = attrs) {

    private lateinit var viewComponentLoadingLocationBinding: ComponentLoadingLocationBinding

    init {
        initView(dataBinding = dataBinding(layoutId = R.layout.component_loading_location))
    }

    override fun initView(dataBinding: ComponentLoadingLocationBinding) {
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