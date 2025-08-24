package com.leandro1995.tinkuysabor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.adapter.holder.TourBottomSheetHolder
import com.leandro1995.tinkuysabor.databinding.ItemTourBottomSheetBinding
import com.leandro1995.tinkuysabor.model.entity.Tour

class TourBottomSheetAdapter(private val tourArrayList: ArrayList<Tour>) :
    RecyclerView.Adapter<TourBottomSheetHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): TourBottomSheetHolder {
        return TourBottomSheetHolder(
            itemTourBottomSheetBinding = ItemTourBottomSheetBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: TourBottomSheetHolder, position: Int
    ) {
        holder.itemTourBottomSheetBinding.apply {
            tourSimpleDraweeView.setImageURI(tourArrayList[position].photo)
            tourTitleText.text = tourArrayList[position].title
        }
    }

    override fun getItemCount(): Int {
        return tourArrayList.size
    }
}