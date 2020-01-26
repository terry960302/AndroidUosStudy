package com.example.sendbird_chat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sendbird.android.BaseChannel.SendUserMessageHandler
import com.sendbird.android.OpenChannel
import com.sendbird.android.OpenChannel.*
import com.sendbird.android.SendBird


class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity.class"
    lateinit var rv_users : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_users = findViewById(R.id.rv_users)






    }
}
