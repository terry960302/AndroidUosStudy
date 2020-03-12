package com.example.sendbird_chat.View.Item

import com.example.sendbird_chat.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_chat_item.view.*

class ChatItem(val desc : String) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.tv_chat.text = desc
    }

    override fun getLayout(): Int = R.layout.activity_chat_item
}