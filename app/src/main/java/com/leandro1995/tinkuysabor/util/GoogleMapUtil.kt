package com.leandro1995.tinkuysabor.util

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class GoogleMapUtil(private val googleMap: GoogleMap) {

    fun animateCamera(latLng: LatLng, zoom: Float = 18f) {
        marker(latLng = latLng)
        googleMap.animateCamera(
            CameraUpdateFactory.newCameraPosition(
                CameraPosition.Builder().target(latLng).zoom(zoom).build()
            )
        )
    }

    fun marker(latLngList: List<LatLng>) {
        if (latLngList.isNotEmpty()) {
            latLngList.forEach {
                marker(latLng = it)
            }
        }
    }

    fun isMapToolbarEnabled(isEnable: Boolean) {
        googleMap.uiSettings.isMapToolbarEnabled = isEnable
    }

    fun isScrollGesturesEnabled(isEnable: Boolean) {
        googleMap.uiSettings.isScrollGesturesEnabled = isEnable
    }

    fun resetMap() {
        googleMap.clear()
    }

    private fun marker(latLng: LatLng) {
        googleMap.addMarker(MarkerOptions().position(latLng))
    }
}