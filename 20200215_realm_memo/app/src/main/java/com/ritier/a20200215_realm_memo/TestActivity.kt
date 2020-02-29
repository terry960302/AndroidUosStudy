package com.ritier.a20200215_realm_memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        Realm.init(this)

        val realm = Realm.getDefaultInstance()

        //데이터 추가
        val memo = MemoModel(1, "asdasdasda")
        val memo2 = MemoModel(2, "asdasdasda")
        val memo3 = MemoModel(3, "asdasdasda")
        val memo4 = MemoModel(4, "asdasdasda")
        val memo5 = MemoModel(5, "asdasdasda")
        val memo6 = MemoModel(6, "asdasdasda")
        val memo7 = MemoModel(7, "asdasdasda")
        val memo8 = MemoModel(71, "asdasdasda")
        val memo9 = MemoModel(154, "asdasdasda")


        realm.beginTransaction()
        realm.copyToRealmOrUpdate(memo)
        realm.copyToRealmOrUpdate(memo2)
        realm.copyToRealmOrUpdate(memo3)
        realm.copyToRealmOrUpdate(memo4)
        realm.copyToRealmOrUpdate(memo5)
        realm.copyToRealmOrUpdate(memo6)
        realm.copyToRealmOrUpdate(memo7)
        realm.copyToRealmOrUpdate(memo8)
        realm.copyToRealmOrUpdate(memo9)
        realm.commitTransaction()

        //데이터 가져오기
        realm.beginTransaction()
        val data = realm.where(MemoModel::class.java).findAll()
        realm.commitTransaction()


        Log.d("TestActivity", data.toString())
    }
}
