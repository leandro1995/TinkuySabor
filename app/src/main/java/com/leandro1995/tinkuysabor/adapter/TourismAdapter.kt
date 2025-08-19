package com.leandro1995.tinkuysabor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.adapter.config.callback.TourismAdapterCallBack
import com.leandro1995.tinkuysabor.adapter.holder.TourismHolder
import com.leandro1995.tinkuysabor.adapter.holder.config.callback.PositionHolderCallBack
import com.leandro1995.tinkuysabor.databinding.ItemTourismBinding
import com.leandro1995.tinkuysabor.component.model.Tourism

class TourismAdapter(private val tourismArrayList: ArrayList<Tourism>) :
    RecyclerView.Adapter<TourismHolder>(), PositionHolderCallBack {

    var tourismAdapterCallBack: TourismAdapterCallBack? = null

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): TourismHolder {
        return TourismHolder(
            itemTourismBinding = ItemTourismBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            ), positionHolderCallBack = this
        )
    }

    override fun onBindViewHolder(
        holder: TourismHolder, position: Int
    ) {
        holder.itemTourismBinding.apply {
            tourSimpleDraweeView.setImageURI(tourismArrayList[position].tour.photo)
            titleText.text = tourismArrayList[position].tour.title
            descriptionText.text = tourismArrayList[position].tour.description
            timetableText.text = tourismArrayList[position].tour.timetable
        }
    }

    override fun getItemCount(): Int {
        return tourismArrayList.size
    }

    override fun position(position: Int) {
        tourismAdapterCallBack?.tourism(tour = tourismArrayList[position].tour)
    }
}