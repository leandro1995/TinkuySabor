package com.leandro1995.tinkuysabor.model.entity

import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import kotlinx.parcelize.Parcelize

@Parcelize
class Tour(
    val photo: String = "",
    val title: String = "",
    val description: String = "",
    val timetable: String = "",
    private val latitude: Double = 0.0,
    private val longitude: Double = 0.0,
    val address: String = "",
    val email: String = "",
    val phone: String = "",
    val typeTour: TypeTour = TypeTour()
) : Parcelable {

    fun latLng() = LatLng(latitude, longitude)
}