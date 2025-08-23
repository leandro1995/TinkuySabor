package com.leandro1995.tinkuysabor.component.ambient

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.component.ambient.config.callback.LoadingRecyclerComponentAmbientCallBack
import com.leandro1995.tinkuysabor.databinding.ComponentLoadingRecyclerBinding
import com.leandro1995.tinkuysabor.model.design.Message

open class LoadingRecyclerComponentAmbient(context: Context, attrs: AttributeSet?) :
    LoadingComponentAmbient<ComponentLoadingRecyclerBinding>(context = context, attrs = attrs) {

    private lateinit var componentLoadingRecyclerBinding: ComponentLoadingRecyclerBinding
    private var loadingRecyclerComponentAmbientCallBack: LoadingRecyclerComponentAmbientCallBack? =
        null

    init {
        initView(dataBinding = dataBinding(layoutId = R.layout.component_loading_recycler))
    }

    override fun initView(dataBinding: ComponentLoadingRecyclerBinding) {
        componentLoadingRecyclerBinding = dataBinding
        initViewRecycler(recyclerView = componentLoadingRecyclerBinding.recyclerView)
        onClick()
        gone()
    }

    protected fun configRecycler(recyclerView: RecyclerView, isOrientation: Boolean) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context).apply {
                orientation = orientation(isOrientation = isOrientation)
            }
        }
    }

    protected open fun initViewRecycler(recyclerView: RecyclerView) {}

    open fun <T> setAdapter(arrayList: ArrayList<T>) {}

    override fun visible() {
        componentLoadingRecyclerBinding.loadingLinear.visibility = VISIBLE
        componentLoadingRecyclerBinding.errorLinear.visibility = GONE
        componentLoadingRecyclerBinding.recyclerView.visibility = GONE
    }

    override fun gone() {
        componentLoadingRecyclerBinding.loadingLinear.visibility = GONE
        componentLoadingRecyclerBinding.errorLinear.visibility = GONE
        componentLoadingRecyclerBinding.recyclerView.visibility = VISIBLE
    }

    override fun messageError(messageError: Message, buttonError: () -> Unit) {
        if (messageError.isVisible()) {
            componentLoadingRecyclerBinding.loadingLinear.visibility = GONE
            componentLoadingRecyclerBinding.errorLinear.visibility = VISIBLE
            componentLoadingRecyclerBinding.recyclerView.visibility = GONE
            componentLoadingRecyclerBinding.errorText.text =
                messageError.description(context = context)

            instanceAmbientCallBack(buttonError = buttonError)
        }
    }

    override fun onClick() {
        componentLoadingRecyclerBinding.errorButton.setOnClickListener {
            loadingRecyclerComponentAmbientCallBack?.errorButon()
        }
    }

    override fun instanceAmbientCallBack(buttonError: () -> Unit) {
        if (loadingRecyclerComponentAmbientCallBack == null) {
            loadingRecyclerComponentAmbientCallBack =
                object : LoadingRecyclerComponentAmbientCallBack {
                    override fun errorButon() {
                        buttonError()
                    }
                }
        }
    }

    private fun orientation(isOrientation: Boolean) = if (isOrientation) {
        LinearLayoutManager.VERTICAL
    } else {
        LinearLayoutManager.HORIZONTAL
    }
}