package com.leandro1995.tinkuysabor.config

import android.app.Activity
import com.leandro1995.tinkuysabor.R
import com.leandro1995.tinkuysabor.model.design.Carousel

class Setting {

    companion object {
        fun carouselArrayList(activity: Activity) = arrayListOf(
            Carousel(
                title = activity.getString(R.string.carousel_item_1_title_view_pager),
                description = activity.getString(R.string.carousel_item_1_description_view_pager)
            ), Carousel(
                title = activity.getString(R.string.carousel_item_2_title_view_pager),
                description = activity.getString(R.string.carousel_item_2_description_view_pager)
            ), Carousel(
                title = activity.getString(R.string.carousel_item_3_title_view_pager),
                description = activity.getString(R.string.carousel_item_3_description_view_pager)
            ), Carousel(
                title = activity.getString(R.string.carousel_item_4_title_view_pager),
                description = activity.getString(R.string.carousel_item_4_description_view_pager)
            ), Carousel(
                title = activity.getString(R.string.carousel_item_5_title_view_pager),
                description = activity.getString(R.string.carousel_item_5_description_view_pager)
            )
        )
    }
}