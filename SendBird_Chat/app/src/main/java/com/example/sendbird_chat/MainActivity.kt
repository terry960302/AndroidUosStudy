package com.example.sendbird_chat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sendbird_chat.RecyItems.UserItem
import com.sendbird.android.ApplicationUserListQuery
import com.sendbird.android.SendBird
import com.sendbird.android.User
import com.sendbird.android.UserListQuery
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder


class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity.class"
    lateinit var rv_users: RecyclerView
    lateinit var _userAdapter: GroupAdapter<GroupieViewHolder>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //리사이클러뷰 설정
        setRecycelrView()

        //유저 목록 불러오기
        val _applicationUserListQuery: ApplicationUserListQuery =
            SendBird.createApplicationUserListQuery();
        _applicationUserListQuery.next(UserListQuery.UserListQueryResultHandler() { list: List<User>, e ->
            if (e != null) {
                Log.e(TAG, e.message)
            }
            list.forEach{ user : User->
                _userAdapter.add(UserItem(this@MainActivity, user.userId))
            }
        })
    }

    fun setRecycelrView() {
        rv_users = findViewById(R.id.rv_users)
        _userAdapter = GroupAdapter()

        rv_users.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_users.adapter = _userAdapter
    }
}
