package com.example.sendbird_chat.View

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sendbird_chat.R
import com.sendbird.android.SendBird
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var ev_userId: EditText
    lateinit var btn_register: Button
    val TAG: String = "LoginActivity.class"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.title = "회원가입"

        //초기화
        ev_userId = findViewById(R.id.userId)
        btn_register = findViewById(R.id.register)

        btn_register.setOnClickListener {
            if (!TextUtils.isEmpty(ev_userId.text)) {
                registerUser(ev_userId.text.toString())
            } else {
                Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(userId: String){
        SendBird.connect(userId) { user, e ->
            if (e != null) {
                Log.e(TAG,"회원가입 에러 : ${e.message.toString()}")
            }
            Log.d(TAG, "${user.userId}님이 회원가입에 성공했습니다. ")
            moveToMainActivity()
        }
    }

    private fun moveToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
