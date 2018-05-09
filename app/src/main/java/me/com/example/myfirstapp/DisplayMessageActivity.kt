package me.com.example.myfirstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val mainUser = User(intent.getStringExtra(USERNAME),"LastName")
        val message = intent.getStringExtra(BROADCASTMESSAGE)
        val firstname = mainUser.firstName

        findViewById<TextView>(R.id.textView).apply { text = message }
        findViewById<TextView>(R.id.HelloObject).apply { text = "Hello $firstname" }
    }
}
