package com.example.sendbird_chat.RecyItems

import android.content.Context
import android.content.Intent
import com.example.sendbird_chat.ChannelActivity
import com.example.sendbird_chat.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_main_user_item.view.*

class UserItem(val context: Context, val userId : String) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.tv_channelId.text = userId

        viewHolder.itemView.setOnClickListener {
            context.startActivity(Intent(context, ChannelActivity::class.java))
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_main_user_item
    }
}