package com.example.sendbird_chat

import android.app.Application
import com.sendbird.android.SendBird

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        //샌드버드 시작
        SendBird.init(getString(R.string.send_bird_app_id), this)
    }
}