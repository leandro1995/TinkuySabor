package com.leandro1995.tinkuysabor.viewcomponent.loading

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.tinkuysabor.adapter.TourismAdapter
import com.leandro1995.tinkuysabor.databinding.ViewComponentLoadingRecyclerBinding
import com.leandro1995.tinkuysabor.viewcomponent.ambient.LoadingRecyclerComponentAmbient

class TourismListLoadingRecyclerViewComponent(context: Context, attrs: AttributeSet?) :
    LoadingRecyclerComponentAmbient(context = context, attrs = attrs) {

    override fun initView(dataBinding: ViewComponentLoadingRecyclerBinding) {
        dataBinding.recyclerView.apply {
            configRecycler(recyclerView = this, isOrientation = true)
            adapter = TourismAdapter()
        }
    }
}