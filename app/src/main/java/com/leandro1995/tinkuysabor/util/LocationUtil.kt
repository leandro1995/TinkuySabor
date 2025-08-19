package com.leandro1995.tinkuysabor.util

import android.app.Activity
import android.content.IntentSender
import androidx.activity.result.IntentSenderRequest
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.Priority

class LocationUtil(private val activity: Activity) {

    fun verifyLocation(messageError: (intentSenderRequest: IntentSenderRequest) -> Unit) {
        task().addOnSuccessListener {
            
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