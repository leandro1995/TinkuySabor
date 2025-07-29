package com.leandro1995.tinkuysabor.fcm.messaging

import android.annotation.SuppressLint
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.leandro1995.tinkuysabor.model.design.Notification

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class FCMApplicationMessaging : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        Notification(
            context = baseContext, remoteMessageNotification = message.notification
        ).create()
    }
}