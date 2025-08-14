package com.leandro1995.tinkuysabor.viewcomponent.loading

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.adapter.TourismAdapter
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.viewcomponent.ambient.LoadingRecyclerComponentAmbient
import com.leandro1995.tinkuysabor.viewcomponent.model.Tourism

class TourismListLoadingRecyclerViewComponent(context: Context, attrs: AttributeSet?) :
    LoadingRecyclerComponentAmbient(context = context, attrs = attrs) {
    private lateinit var tourismArrayList: ArrayList<Tourism>
    private lateinit var tourismAdapter: TourismAdapter

    override fun initViewRecycler(recyclerView: RecyclerView) {
        tourismArrayList = arrayListOf()
        tourismAdapter = TourismAdapter(tourismArrayList = tourismArrayList)

        recyclerView.apply {
            configRecycler(recyclerView = this, isOrientation = true)
            adapter = tourismAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun <T> setAdapter(arrayList: ArrayList<T>) {
        arrayList.forEach {
            tourismArrayList.add(Tourism(tour = it as Tour))
        }
        tourismAdapter.notifyDataSetChanged()
    }
}