package com.leandro1995.tinkuysabor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.adapter.holder.CarouselHolder
import com.leandro1995.tinkuysabor.model.design.Carousel

class CarouselAdapter(private val carouselArrayList: ArrayList<Carousel>) :
    RecyclerView.Adapter<CarouselHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CarouselHolder {
        return CarouselHolder(
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_carousel, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: CarouselHolder, position: Int
    ) {
        holder.titleText.text = carouselArrayList[position].title
        holder.descriptionText.text = carouselArrayList[position].description
    }

    override fun getItemCount(): Int {
        return carouselArrayList.size
    }
}