package com.leandro1995.tinkuysabor.fcm.messaging

import android.annotation.SuppressLint
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class FCMApplicationMessaging : FirebaseMessagingService() {
    
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
    }
}