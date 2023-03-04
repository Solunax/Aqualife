package com.project.aqualife

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessagingService : FirebaseMessagingService() {
    lateinit var notificationManager : NotificationManager
    private val channelID = "com.project.aqualife"
    private val notificationID = 1
    private var isCreated = false

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("FCM", "From : ${message.from}")

        if(message.notification != null)
            showNotification(message.notification)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    private fun showNotification(message: RemoteMessage.Notification?){
        if(!isCreated){
            notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "AquaLife"
                val descriptionText = "알림"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(channelID, name, importance).apply {
                    description = descriptionText
                }

                notificationManager.createNotificationChannel(channel)
            }

            isCreated = true
        }

        val notification = NotificationCompat.Builder(this, channelID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(message?.title)
            .setContentText(message?.body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(notificationID, notification)
    }
}