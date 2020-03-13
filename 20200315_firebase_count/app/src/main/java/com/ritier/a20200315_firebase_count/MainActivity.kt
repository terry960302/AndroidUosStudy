package com.ritier.a20200315_firebase_count

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.robinhood.ticker.TickerUtils
import com.robinhood.ticker.TickerView
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    private lateinit var tickerView: TickerView
    private lateinit var cv_send: CardView
    private lateinit var cv_deposit: CardView
    private lateinit var docRef: DocumentReference
    var myCurrentMoney: Int = 0

    val db: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //초기화
        tickerView = findViewById(R.id.tickerView)
        cv_send = findViewById(R.id.cv_send)
        cv_deposit = findViewById(R.id.cv_deposit)
        docRef = db.collection("Money").document("doc1")

        //초기 세팅
        setTickerLibrary()
        getCurrentMoney()

        //송금하기
        cv_send.setOnClickListener {
            sendMoney()
        }

        //입금하기
        cv_deposit.setOnClickListener {
            depositMoney()
        }
    }

    private fun getCurrentMoney() {
        docRef.addSnapshotListener { ds, err ->
            if (err != null) {
                Log.e(TAG, "금액 데이터 가져오기 에러 : $err")
            }

            if (ds != null && ds.exists()) {
                val data = ds.data!!

                val currentMoney = Integer.parseInt(data["current_money"].toString())

                myCurrentMoney = currentMoney

                if(currentMoney == 0){
                    tickerView.text = "0,000"
                }else{
                    val startNum =
                        Math.pow(10.toDouble(), (currentMoney.toString().length - 1).toDouble()).toInt()

                    for (i in startNum..currentMoney step startNum) {
                        tickerView.text = currencyFormat(i)
                    }
                    tickerView.text = currencyFormat(currentMoney)
                }
            }
        }
    }

    private fun sendMoney() {
        if (myCurrentMoney - 1000 >= 0) {
            docRef.set(
                hashMapOf(
                    "current_money" to (myCurrentMoney - 1250)
                ), SetOptions.merge()
            ).addOnSuccessListener {
                Toast.makeText(this, "출금되었습니다.", Toast.LENGTH_SHORT).show()
            }.addOnCanceledListener {
                Toast.makeText(this, "출금 취소되었습니다.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Handler().post {
                Toast.makeText(this, "잔고가 부족합니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun depositMoney() {
        docRef.set(
            hashMapOf(
                "current_money" to (myCurrentMoney + 1250)
            ), SetOptions.merge()
        ).addOnSuccessListener {
            Toast.makeText(this, "입금되었습니다.", Toast.LENGTH_SHORT).show()
        }.addOnCanceledListener {
            Toast.makeText(this, "입금 취소되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setTickerLibrary() {
        tickerView.setCharacterLists(TickerUtils.provideNumberList())
        tickerView.animationDuration = 2000
        tickerView.setPreferredScrollingDirection(TickerView.ScrollingDirection.DOWN)
    }

    private fun currencyFormat(degree: Int) =
        NumberFormat.getInstance(Locale.getDefault()).format(degree)
}
