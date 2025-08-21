package com.leandro1995.tinkuysabor.component.loading

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.component.ambient.LoadingComponentAmbient
import com.leandro1995.tinkuysabor.databinding.ViewComponentLoadingBinding

class LoadingViewComponent(context: Context, attrs: AttributeSet?) :
    LoadingComponentAmbient<ViewComponentLoadingBinding>(context = context, attrs = attrs) {

    private lateinit var viewComponentLoadingBinding: ViewComponentLoadingBinding

    init {
        initView(dataBinding = dataBinding(layoutId = R.layout.view_component_loading))
    }

    override fun initView(dataBinding: ViewComponentLoadingBinding) {
        viewComponentLoadingBinding = dataBinding
        gone()
    }

    override fun visible() {
        viewComponentLoadingBinding.loadingLinear.visibility = VISIBLE
        viewComponentLoadingBinding.errorLinear.visibility = GONE
    }

    override fun gone() {
        viewComponentLoadingBinding.loadingLinear.visibility = GONE
        viewComponentLoadingBinding.errorLinear.visibility = GONE
    }
}