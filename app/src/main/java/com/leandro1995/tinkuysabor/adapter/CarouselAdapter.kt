package com.leandro1995.tinkuysabor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.adapter.holder.CarouselHolder
import com.leandro1995.tinkuysabor.databinding.ItemCarouselBinding
import com.leandro1995.tinkuysabor.model.design.Carousel

class CarouselAdapter(private val carouselArrayList: ArrayList<Carousel>) :
    RecyclerView.Adapter<CarouselHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CarouselHolder {
        return CarouselHolder(
            itemCarouselBinding = ItemCarouselBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: CarouselHolder, position: Int
    ) {
        holder.itemCarouselBinding.apply {
            titleText.text = carouselArrayList[position].title
            descriptionText.text = carouselArrayList[position].description
            carouselImage.setImageResource(carouselArrayList[position].imageDrawable)
        }
    }

    override fun getItemCount(): Int {
        return carouselArrayList.size
    }
}