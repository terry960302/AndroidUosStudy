package com.example.a20200119_horizontalrecy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class MainActivity : AppCompatActivity() {

    //선언
    lateinit var rv_upper : RecyclerView
    lateinit var rv_lower : RecyclerView
    lateinit var upperAdapter : GroupAdapter<GroupieViewHolder>
    lateinit var lowerAdapter : GroupAdapter<GroupieViewHolder>

    //뷰가 만들어질 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //초기화
        rv_upper = findViewById(R.id.rv_upper)
        rv_lower = findViewById(R.id.rv_lower)
        upperAdapter = GroupAdapter()
        lowerAdapter = GroupAdapter()

        //리사이클러뷰 방향 설정
        rv_upper.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_lower.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        //어댑터에 데이터 설정
        for(i in 1..10){
            upperAdapter.add(MyItem("Sun Flower", "Created : 20.01.19", R.drawable.image_1, R.drawable.ic_local_florist_black_24dp))
        }
        for(i in 1..10){
            lowerAdapter.add(MyItem("Sejeong Kim", "Created : 20.01.19", R.drawable.image_2, R.drawable.ic_person_black_24dp))
        }

        //리사이클러뷰와 어댑터 연결
        rv_upper.adapter = upperAdapter
        rv_lower.adapter = lowerAdapter
    }
}
