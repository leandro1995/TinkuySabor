package com.leandro1995.tinkuysabor.component.loading

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.activity.TourismDetailActivity
import com.leandro1995.tinkuysabor.adapter.TourismAdapter
import com.leandro1995.tinkuysabor.adapter.config.callback.TourismAdapterCallBack
import com.leandro1995.tinkuysabor.config.Setting
import com.leandro1995.tinkuysabor.model.entity.Tour
import com.leandro1995.tinkuysabor.component.ambient.LoadingRecyclerComponentAmbient
import com.leandro1995.tinkuysabor.component.model.Tourism

class TourismListLoadingRecyclerViewComponent(context: Context, attrs: AttributeSet?) :
    LoadingRecyclerComponentAmbient(context = context, attrs = attrs) {
    private lateinit var tourismArrayList: ArrayList<Tourism>
    private lateinit var tourismAdapter: TourismAdapter

    override fun initViewRecycler(recyclerView: RecyclerView) {
        tourismArrayList = arrayListOf()
        tourismAdapter = TourismAdapter(tourismArrayList = tourismArrayList)

        tourismAdapter.tourismAdapterCallBack = object : TourismAdapterCallBack {
            override fun tourism(tour: Tour) {
                context.startActivity(Intent(context, TourismDetailActivity::class.java).apply {
                    putExtra(Setting.TOUR_PUT_EXTRA, tour)
                })
            }
        }

        recyclerView.apply {
            configRecycler(recyclerView = this, isOrientation = true)
            adapter = tourismAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun <T> setAdapter(arrayList: ArrayList<T>) {
        tourismArrayList.clear()

        arrayList.forEach {
            tourismArrayList.add(Tourism(tour = it as Tour))
        }
        tourismAdapter.notifyDataSetChanged()
    }
}