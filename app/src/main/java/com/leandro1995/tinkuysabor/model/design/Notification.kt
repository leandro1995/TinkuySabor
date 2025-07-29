package com.leandro1995.tinkuysabor.model.design

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.RemoteMessage
import com.leandro1995.tinkuysabor.R

class Notification(
    private val context: Context, private val remoteMessageNotification: RemoteMessage.Notification?
) {

    fun create() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager().createNotificationChannel(notificationChannel())
        }

        notificationManager().notify(0, notificationCompatBuilder())
    }

    private fun notificationCompatBuilder() =
        NotificationCompat.Builder(context, context.getString(R.string.channel_notification))
            .setSmallIcon(R.drawable.ic_message).setContentTitle(title()).setContentText(message())
            .setAutoCancel(true).build()

    private fun notificationManager() =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    @RequiresApi(Build.VERSION_CODES.O)
    private fun notificationChannel() = NotificationChannel(
        context.getString(R.string.channel_notification),
        context.getString(R.string.name_notification),
        NotificationManager.IMPORTANCE_DEFAULT
    )

    private fun title() = remoteMessageNotification?.title

    private fun message() = remoteMessageNotification?.body
}