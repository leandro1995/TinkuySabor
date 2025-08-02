package com.leandro1995.tinkuysabor.viewcomponent.ambient

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.databinding.ViewComponentLoadingRecyclerBinding

open class LoadingRecyclerComponentAmbient(context: Context, attrs: AttributeSet?) :
    ViewComponentAmbient<ViewComponentLoadingRecyclerBinding>(context = context, attrs = attrs) {

    init {
        initView(dataBinding = dataBinding(layoutId = R.layout.view_component_loading_recycler))
    }

    protected fun configRecycler(recyclerView: RecyclerView, isOrientation: Boolean) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context).apply {
                orientation = orientation(isOrientation = isOrientation)
            }
        }
    }

    private fun orientation(isOrientation: Boolean) = if (isOrientation) {
        LinearLayoutManager.VERTICAL
    } else {
        LinearLayoutManager.HORIZONTAL
    }
}