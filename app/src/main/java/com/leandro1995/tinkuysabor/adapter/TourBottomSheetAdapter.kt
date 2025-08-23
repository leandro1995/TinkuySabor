package com.leandro1995.tinkuysabor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.adapter.holder.TourBottomSheetHolder
import com.leandro1995.tinkuysabor.databinding.ItemTourismBottomSheetBinding
import com.leandro1995.tinkuysabor.model.entity.Tour

class TourBottomSheetAdapter(private val tourArrayList: ArrayList<Tour>) :
    RecyclerView.Adapter<TourBottomSheetHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): TourBottomSheetHolder {
        return TourBottomSheetHolder(
            itemTourismBottomSheetBinding = ItemTourismBottomSheetBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: TourBottomSheetHolder, position: Int
    ) {

    }

    override fun getItemCount(): Int {
        return tourArrayList.size
    }
}