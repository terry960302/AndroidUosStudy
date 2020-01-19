package com.example.simple_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class MainActivity : AppCompatActivity() {

    lateinit var rv_main : RecyclerView
    lateinit var _adapter: GroupAdapter<GroupieViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //리사이클러뷰 초기화
        rv_main = findViewById(R.id.rv_main)

        //어댑터 초기화
        _adapter = GroupAdapter()
        val _content = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        //데이터 설정
        for(i in 1..10){
            _adapter.add(MyItem(R.drawable.image_1, _content))
            _adapter.add(MyItem(R.drawable.image_1, _content))
            _adapter.add(MyItem(R.drawable.image_1, _content))
            _adapter.add(MyItem(R.drawable.image_1, _content))
        }

        //리사이클러뷰 방향 설정
        rv_main.layoutManager   = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        //어댑터 연결
        rv_main.adapter  = _adapter

    }
}
