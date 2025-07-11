package com.leandro1995.tinkuysabor.adapter.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.R

class CarouselHolder(view: View) : RecyclerView.ViewHolder(view) {
    val titleText: TextView = view.findViewById(R.id.title_text)
    val descriptionText: TextView = view.findViewById(R.id.description_text)
    val carouselImage: ImageView = view.findViewById(R.id.carousel_image)
}