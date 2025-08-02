package com.leandro1995.tinkuysabor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.adapter.holder.TourismHolder
import com.leandro1995.tinkuysabor.databinding.ItemTourismBinding

class TourismAdapter : RecyclerView.Adapter<TourismHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TourismHolder {
        return TourismHolder(
            itemTourismBinding = ItemTourismBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: TourismHolder,
        position: Int
    ) {

    }

    override fun getItemCount(): Int {
        return 20
    }
}