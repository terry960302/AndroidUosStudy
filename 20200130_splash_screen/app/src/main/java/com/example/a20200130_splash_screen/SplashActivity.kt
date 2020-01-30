package com.example.a20200130_splash_screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class SplashActivity : AppCompatActivity() , Animation.AnimationListener{

    //선언
    lateinit var iv_logo : ImageView
    lateinit var pb_splash : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //상단바 제거
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)

        //초기화
        iv_logo = findViewById(R.id.iv_logo)
        pb_splash = findViewById(R.id.pb_splash)

        //애니메이션
        val fadeAnim : Animation = AnimationUtils.loadAnimation(this, R.anim.logo_fade_in)
        fadeAnim.setAnimationListener(this)

        //서로 연동
        iv_logo.animation = fadeAnim

        //로딩바 숨기기
        pb_splash.visibility = View.INVISIBLE
    }

    override fun onAnimationRepeat(animation: Animation?) {
        //반복할 경우
    }

    override fun onAnimationEnd(animation: Animation?) {

        //로딩바 보이기
        pb_splash.visibility = View.VISIBLE

        //2초 텀 두고
        Timer().schedule(object : TimerTask() {
            override fun run() {
                //다음 창 이동
                val intent  = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 2000)
    }

    override fun onAnimationStart(animation: Animation?) {
        //애니메이션 시작할 때
    }
}
