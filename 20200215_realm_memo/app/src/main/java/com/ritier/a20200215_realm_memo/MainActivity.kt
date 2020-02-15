package com.ritier.a20200215_realm_memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults

class MainActivity : AppCompatActivity() {

    lateinit var memoAdapter : GroupAdapter<GroupieViewHolder>
    lateinit var rv_list : RecyclerView
    lateinit var fb_add : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDummyData()
        setRecyclerView()

        fb_add = findViewById(R.id.fb_add)
        fb_add.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddActivity::class.java))
            finish()
        }


    }

    fun setRecyclerView(){
        rv_list = findViewById(R.id.rv_list)
        rv_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_list.adapter = memoAdapter
    }

    fun setDummyData(){
        memoAdapter = GroupAdapter()

        getRealmData().forEach {
            memoAdapter.add(MemoItem(it))
        }

        //연습용 데이터들
//        memoAdapter.add(MemoItem(MemoModel(0, "asdas")))
//        memoAdapter.add(MemoItem(MemoModel(0, "asdas")))
//        memoAdapter.add(MemoItem(MemoModel(0, "asdas")))
//        memoAdapter.add(MemoItem(MemoModel(0, "asdas")))
//        memoAdapter.add(MemoItem(MemoModel(0, "asdas")))

    }

    fun getRealmData() : List<MemoModel>{
        Realm.init(applicationContext)
        val realm = Realm.getDefaultInstance()

        val results  : RealmResults<MemoModel> = realm.where(MemoModel::class.java).findAll()

        Log.d("MainActivity", "Realm에서 가져온 메모들 : ${results.toString()}")

        return results.toList()
    }
}
