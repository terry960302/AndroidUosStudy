package com.example.sendbird_chat.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sendbird_chat.R
import com.example.sendbird_chat.View.Item.item
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class TestActivity : AppCompatActivity() {

    lateinit var rv_lower: RecyclerView
    lateinit var adapter : GroupAdapter<GroupieViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        supportActionBar?.hide()

        adapter = GroupAdapter()

        rv_lower = findViewById(R.id.rv_lower)
        adapter.add(item("asdasd"))
        adapter.add(item("asdasd"))
        adapter.add(item("asdasd"))
        adapter.add(item("asdasd"))
        adapter.add(item("asdasd"))
        adapter.add(item("asdasd"))
        adapter.add(item("asdasd"))

        rv_lower.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_lower.isNestedScrollingEnabled = false
        rv_lower.adapter = adapter

    }
}
