package com.example.simple_recyclerview

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_main_item.view.*

class MyItem(private val imageSrc: Int, private val msg: String) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        //이미지 설정
        viewHolder.itemView.iv_user.setImageResource(imageSrc)
        //텍스트 설정
        viewHolder.itemView.tv_message.text = msg
    }

    override fun getLayout(): Int {
        return R.layout.activity_main_item
    }
}