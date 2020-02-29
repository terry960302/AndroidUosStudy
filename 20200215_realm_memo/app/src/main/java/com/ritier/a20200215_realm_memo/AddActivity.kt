package com.ritier.a20200215_realm_memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import io.realm.Realm
import java.lang.Error

class AddActivity : AppCompatActivity() {

    lateinit var ev_input : EditText
    lateinit var cv_submit : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        ev_input = findViewById(R.id.ev_input)
        cv_submit = findViewById(R.id.cv_submit)

        //제출하기
        cv_submit.setOnClickListener {
            if(!TextUtils.isEmpty(ev_input.text.toString())){
                val desc = ev_input.text.toString()
                addMemo(desc)
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this, "메모를 입력해주세요...", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun addMemo(desc : String){
        try{
            val realm = Realm.getDefaultInstance()


            realm.beginTransaction()
            val lastId  : Number? = realm.where(MemoModel::class.java).max("id")

            val memo = MemoModel((lastId ?: -1).toLong() +1,  desc)
            realm.copyToRealm(memo)

            realm.commitTransaction()
        }catch (e : Error){
            Log.e("AddActivity", e.message.toString())
        }

    }
}
