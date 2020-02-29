package com.example.sendbird_chat.View.Item

import android.content.Context
import android.content.Intent
import com.example.sendbird_chat.View.ChatActivity
import com.example.sendbird_chat.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_channel_item.view.*

class ChannelItem(val context : Context, val channelId : String) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.tv_channelId.text = channelId

        viewHolder.itemView.setOnClickListener {
            context.startActivity(Intent(context, ChatActivity::class.java))
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_channel_item
    }
}