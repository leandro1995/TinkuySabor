package com.leandro1995.tinkuysabor.util

import android.Manifest
import android.app.Activity
import android.content.IntentSender
import android.os.Looper
import androidx.activity.result.IntentSenderRequest
import androidx.annotation.RequiresPermission
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.Priority

class LocationUtil(private val activity: Activity) {

    private var fusedLocationProviderClient: FusedLocationProviderClient? = null
    private var locationCallback: LocationCallback? = null

    fun verifyLocation(
        method: () -> Unit, messageError: (intentSenderRequest: IntentSenderRequest) -> Unit
    ) {
        task().addOnSuccessListener {
            method()
        }

        task().addOnFailureListener { exception ->
            if (exception is ResolvableApiException) {
                try {
                    messageError(IntentSenderRequest.Builder(exception.resolution).build())
                } catch (_: IntentSender.SendIntentException) {

                }
            }
        }
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun starLocation(method: (latitude: Double, longitude: Double) -> Unit) {
        instanceLocationCallback(method = method)
        instanceFusedLocationProviderClient()?.requestLocationUpdates(
            locationRequest(), locationCallback!!, Looper.getMainLooper()
        )
    }

    fun stopLocation() {
        if (locationCallback != null) {
            instanceFusedLocationProviderClient()?.removeLocationUpdates(locationCallback!!)
        }
    }

    private fun instanceLocationCallback(method: (latitude: Double, longitude: Double) -> Unit) {
        if (locationCallback == null) {
            locationCallback = object : LocationCallback() {
                override fun onLocationResult(locantionResult: LocationResult) {
                    for (location in locantionResult.locations) {
                        method(location.latitude, location.longitude)
                        stopLocation()
                    }
                }
            }
        }
    }

    private fun instanceFusedLocationProviderClient(): FusedLocationProviderClient? {
        if (fusedLocationProviderClient == null) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity)
        }
        return fusedLocationProviderClient
    }

    private fun locationRequest() =
        LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, INTERVAL_MILLIS)
            .setMinUpdateIntervalMillis(MIN_UPDATE_INTERVAL_MILLIS).build()

    private fun builder() = LocationSettingsRequest.Builder().addLocationRequest(locationRequest())

    private fun client() = LocationServices.getSettingsClient(activity)

    private fun task() = client().checkLocationSettings(builder().build())

    companion object {
        private const val INTERVAL_MILLIS = 10000L
        private const val MIN_UPDATE_INTERVAL_MILLIS = 5000L
    }
}