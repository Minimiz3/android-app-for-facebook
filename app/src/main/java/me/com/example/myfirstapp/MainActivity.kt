package me.com.example.myfirstapp

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

const val BROADCASTMESSAGE = "broadcastMessage"
const val USERNAME = "username"
const val NOTIFICATION_ID = 1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View){
        val broadcastMessage = findViewById<EditText>(R.id.broadcastMessage)
        val userName = findViewById<EditText>(R.id.usernameField)
        val notificationIntent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(BROADCASTMESSAGE, broadcastMessage.text.toString())
            putExtra(USERNAME,userName.text.toString())
        }
        sendNotification(notificationIntent)
    }

    private fun sendNotification(intent: Intent) {
        val pendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID, intent,PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = NotificationCompat.Builder(this, NOTIFICATION_ID.toString())
        builder.setSmallIcon(R.drawable.abc_ic_star_black_16dp)
        builder.setContentIntent(pendingIntent)
        builder.setAutoCancel(true)

        builder.setContentTitle("My First app notification")
        builder.setContentText(intent.getStringExtra(BROADCASTMESSAGE))

        val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID,builder.build())

    }
}
