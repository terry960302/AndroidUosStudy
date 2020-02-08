package com.example.a20200208_firebase_login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class StartActivity : AppCompatActivity() {

    lateinit var providers: ArrayList<AuthUI.IdpConfig>
    val RC_SIGN_IN = 1001
    val TAG = "TAGStartActivity"

    lateinit var btn_start: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        //로그인 지원 방식 설정
        providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
        )

        //버튼 클릭
        btn_start = findViewById(R.id.btn_start)
        btn_start.setOnClickListener {
            //로그인 시작
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(),
                RC_SIGN_IN
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                //로그인 성공
                val user = FirebaseAuth.getInstance().currentUser
                Log.d(TAG, "로그인에 성공했습니다. => ${user?.displayName}")
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Log.d(
                    TAG, "로그인에 실패했습니다. => ${response?.error?.errorCode}"
                )
            }
        }
    }
}
