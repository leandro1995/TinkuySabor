@file:Suppress("DEPRECATION")

package com.leandro1995.tinkuysabor.util

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

object TwoWayBindingUtil {
    @BindingAdapter("fresco:image")
    @JvmStatic
    fun setFrescoImage(simpleDraweeView: SimpleDraweeView, url: String) {
        simpleDraweeView.setImageURI(url)
    }
}