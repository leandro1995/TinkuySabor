package com.leandro1995.tinkuysabor.component.loading

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.component.ambient.LoadingComponentAmbient
import com.leandro1995.tinkuysabor.component.loading.config.callback.LoadingViewComponentCallBack
import com.leandro1995.tinkuysabor.databinding.ViewComponentLoadingBinding
import com.leandro1995.tinkuysabor.model.design.Message

class LoadingViewComponent(context: Context, attrs: AttributeSet?) :
    LoadingComponentAmbient<ViewComponentLoadingBinding>(context = context, attrs = attrs) {

    private lateinit var viewComponentLoadingBinding: ViewComponentLoadingBinding
    private var loadingViewComponentCallBack: LoadingViewComponentCallBack? = null

    init {
        initView(dataBinding = dataBinding(layoutId = R.layout.view_component_loading))
    }

    override fun initView(dataBinding: ViewComponentLoadingBinding) {
        viewComponentLoadingBinding = dataBinding
        onClick()
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

    override fun messageError(messageError: Message, buttonError: () -> Unit) {
        if (messageError.isVisible()) {
            viewComponentLoadingBinding.loadingLinear.visibility = GONE
            viewComponentLoadingBinding.errorLinear.visibility = VISIBLE
            viewComponentLoadingBinding.errorText.text = messageError.description(context = context)

            instanceAmbientCallBack(buttonError = buttonError)
        }
    }

    override fun instanceAmbientCallBack(buttonError: () -> Unit) {
        if (loadingViewComponentCallBack == null) {
            loadingViewComponentCallBack = object : LoadingViewComponentCallBack {
                override fun errorButon() {
                    buttonError()
                }
            }
        }
    }

    override fun onClick() {
        viewComponentLoadingBinding.errorButton.setOnClickListener {
            loadingViewComponentCallBack?.errorButon()
        }
    }
}