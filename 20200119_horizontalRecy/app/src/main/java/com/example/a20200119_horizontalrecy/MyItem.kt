package com.example.a20200119_horizontalrecy

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_main_item.view.*

class MyItem (val name:  String, val createdAt : String, val imageSrc : Int, val iconSrc :Int): Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        //텍스트 설정
        viewHolder.itemView.tv_name.text = name
        viewHolder.itemView.tv_time.text = createdAt

        //이미지 설정
        viewHolder.itemView.iv_icon.setImageResource(iconSrc)
        viewHolder.itemView.iv_main.setImageResource(imageSrc)
    }

    override fun getLayout(): Int {
        return R.layout.activity_main_item
    }
}