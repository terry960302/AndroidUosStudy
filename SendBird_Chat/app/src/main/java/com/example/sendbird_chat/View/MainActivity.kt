package com.example.sendbird_chat.View

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sendbird_chat.R
import com.example.sendbird_chat.View.Item.UserItem
import com.sendbird.android.ApplicationUserListQuery
import com.sendbird.android.SendBird
import com.sendbird.android.User
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder


class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity.class"
    lateinit var rv_users: RecyclerView
    lateinit var _userAdapter: GroupAdapter<GroupieViewHolder>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "유저 목록"

        //리사이클러뷰 설정
        initRecyclerView()

        //유저 목록 불러오기
        val usersQuery =
            SendBird.createApplicationUserListQuery()
        usersQuery.next { users: List<User>, e ->
            if (e != null) {
                Log.e(TAG, e.message.toString())
            }
            users.forEach{ user : User->
                _userAdapter.add(
                    UserItem(
                        this@MainActivity,
                        user.userId
                    )
                )
            }
        }
    }

    fun initRecyclerView() {
        rv_users = findViewById(R.id.rv_users)
        _userAdapter = GroupAdapter()

        rv_users.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_users.adapter = _userAdapter
    }
}
