package com.leandro1995.tinkuysabor.component.loading

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.component.ambient.LoadingComponentAmbient
import com.leandro1995.tinkuysabor.component.loading.config.callback.LoadingComponentCallBack
import com.leandro1995.tinkuysabor.databinding.ComponentLoadingBinding
import com.leandro1995.tinkuysabor.model.design.Message

class LoadingComponent(context: Context, attrs: AttributeSet?) :
    LoadingComponentAmbient<ComponentLoadingBinding>(context = context, attrs = attrs) {

    private lateinit var viewComponentLoadingBinding: ComponentLoadingBinding
    private var loadingComponentCallBack: LoadingComponentCallBack? = null

    init {
        initView(dataBinding = dataBinding(layoutId = R.layout.component_loading))
    }

    override fun initView(dataBinding: ComponentLoadingBinding) {
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
        if (loadingComponentCallBack == null) {
            loadingComponentCallBack = object : LoadingComponentCallBack {
                override fun errorButon() {
                    buttonError()
                }
            }
        }
    }

    override fun onClick() {
        viewComponentLoadingBinding.errorButton.setOnClickListener {
            loadingComponentCallBack?.errorButon()
        }
    }
}