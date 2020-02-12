package com.example.sendbird_chat

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_channel_item.view.*

class item(val text : String) : Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.tv_channelId.text = text
    }

    override fun getLayout(): Int {
       return R.layout.activity_channel_item
    }
}