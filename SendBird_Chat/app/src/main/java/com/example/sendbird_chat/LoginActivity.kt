package com.example.sendbird_chat

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sendbird.android.SendBird

class LoginActivity : AppCompatActivity() {

    lateinit var ev_userId: EditText
    lateinit var btn_register: Button
    val TAG : String = "LoginActivity.class"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //샌드버드 시작
        SendBird.init(getString(R.string.send_bird_app_id), applicationContext)

        //초기화
        ev_userId = findViewById(R.id.userId)
        btn_register = findViewById(R.id.register)

        btn_register.setOnClickListener {
            if (!TextUtils.isEmpty(ev_userId.text)) {
                SendBird.connect(ev_userId.text.toString(), SendBird.ConnectHandler{ user, e ->
                    if(e != null) {
                        Log.e(TAG, e.message)
                    }
                    Log.d(TAG, "성공적으로 유저 등록 성공 => ${user.userId}")
                    startActivity(Intent(this, MainActivity::class.java))
                })
            } else {
                Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
