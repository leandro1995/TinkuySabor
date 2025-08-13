package com.leandro1995.tinkuysabor.viewcomponent.loading

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.adapter.TourismAdapter
import com.leandro1995.tinkuysabor.viewcomponent.ambient.LoadingRecyclerComponentAmbient

class TourismListLoadingRecyclerViewComponent(context: Context, attrs: AttributeSet?) :
    LoadingRecyclerComponentAmbient(context = context, attrs = attrs) {

    override fun initViewRecycler(recyclerView: RecyclerView) {
        recyclerView.apply {
            configRecycler(recyclerView = this, isOrientation = true)
            adapter = TourismAdapter()
        }
    }
}