package com.example.sendbird_chat.View.Item

import android.content.Context
import android.content.Intent
import com.example.sendbird_chat.View.ChannelActivity
import com.example.sendbird_chat.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_main_user_item.view.*

class UserItem(val context: Context, val userId : String) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.tv_channelId.text = userId

        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, ChannelActivity::class.java)

            context.startActivity(intent)
        }
    }

    override fun getLayout(): Int =  R.layout.activity_main_user_item
}