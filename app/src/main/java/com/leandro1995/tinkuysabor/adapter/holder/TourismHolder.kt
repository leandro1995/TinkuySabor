package com.leandro1995.tinkuysabor.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.adapter.holder.config.callback.PositionHolderCallBack
import com.leandro1995.tinkuysabor.databinding.ItemTourismBinding

class TourismHolder(
    val itemTourismBinding: ItemTourismBinding, positionHolderCallBack: PositionHolderCallBack?
) : RecyclerView.ViewHolder(itemTourismBinding.root) {

    init {
        itemTourismBinding.tourismDetailImageButton.setOnClickListener {
            positionHolderCallBack?.position(position = bindingAdapterPosition)
        }
    }
}