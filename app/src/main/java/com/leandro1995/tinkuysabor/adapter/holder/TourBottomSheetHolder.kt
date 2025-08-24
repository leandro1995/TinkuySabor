package com.leandro1995.tinkuysabor.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.tinkuysabor.adapter.holder.config.callback.TourBottomSheetHolderCallBack
import com.leandro1995.tinkuysabor.databinding.ItemTourBottomSheetBinding

class TourBottomSheetHolder(
    val itemTourBottomSheetBinding: ItemTourBottomSheetBinding,
    private val tourBottomSheetHolderCallBack: TourBottomSheetHolderCallBack?
) : RecyclerView.ViewHolder(itemTourBottomSheetBinding.root) {

    init {
        itemTourBottomSheetBinding.tourSimpleDraweeView.setOnClickListener {
            tourBottomSheetHolderCallBack?.animateCamera(position = bindingAdapterPosition)
        }

        itemTourBottomSheetBinding.tourismDetailImageButton.setOnClickListener {
            tourBottomSheetHolderCallBack?.tourDetail(position = bindingAdapterPosition)
        }
    }
}