package com.leandro1995.tinkuysabor.viewcomponent.ambient

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.ViewComponentLoadingRecyclerBinding

open class LoadingRecyclerComponentAmbient(context: Context, attrs: AttributeSet?) :
    LoadingComponentAmbient<ViewComponentLoadingRecyclerBinding>(context = context, attrs = attrs) {

    private lateinit var viewComponentLoadingRecyclerBinding: ViewComponentLoadingRecyclerBinding

    init {
        initView(dataBinding = dataBinding(layoutId = R.layout.view_component_loading_recycler))
    }

    override fun initView(dataBinding: ViewComponentLoadingRecyclerBinding) {
        viewComponentLoadingRecyclerBinding = dataBinding
        initViewRecycler(recyclerView = viewComponentLoadingRecyclerBinding.recyclerView)
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
        viewComponentLoadingRecyclerBinding.loadingLinear.visibility = VISIBLE
        viewComponentLoadingRecyclerBinding.errorLinear.visibility = GONE
        viewComponentLoadingRecyclerBinding.recyclerView.visibility = GONE
    }

    override fun gone() {
        viewComponentLoadingRecyclerBinding.loadingLinear.visibility = GONE
        viewComponentLoadingRecyclerBinding.errorLinear.visibility = GONE
        viewComponentLoadingRecyclerBinding.recyclerView.visibility = VISIBLE
    }

    override fun messageError(messageError: String) {
        viewComponentLoadingRecyclerBinding.loadingLinear.visibility = GONE
        viewComponentLoadingRecyclerBinding.errorLinear.visibility = VISIBLE
        viewComponentLoadingRecyclerBinding.recyclerView.visibility = GONE
        viewComponentLoadingRecyclerBinding.errorText.text = messageError
    }

    private fun orientation(isOrientation: Boolean) = if (isOrientation) {
        LinearLayoutManager.VERTICAL
    } else {
        LinearLayoutManager.HORIZONTAL
    }
}