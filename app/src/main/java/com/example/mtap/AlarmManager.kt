package com.example.mtap

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmManager : AppCompatActivity() {
    val NOTIFICATION_ID = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_manager)
        var btnToggle = findViewById<ToggleButton>(R.id.alarmToggle)
        //var contentintent= Intent(this,AlarmManager::class.java)
        btnToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                deliverNotification()
                Toast.makeText(this, "On", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Off", Toast.LENGTH_LONG).show()
            }
            //var contentPendingIntent=PendingIntent.getActivity(this,NOTIFICATION_ID,contentintent,PendingIntent.FLAG_UPDATE_CURRENT)

        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel"
            val descriptionText = "nothing"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun deliverNotification() {
        createNotificationChannel()
        var builder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("StandUp")
            .setContentText("Time to stand up")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(NOTIFICATION_ID, builder.build())
        }

    }
}