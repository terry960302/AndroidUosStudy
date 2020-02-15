package com.ritier.a20200215_realm_memo

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_main_item.view.*

class MemoItem(val memoModel: MemoModel) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.itemView.tv_memo.text = memoModel.desc

        viewHolder.itemView.setOnClickListener {
            //TODO : 상세 창으로 이동
        }
    }

    override fun getLayout(): Int = R.layout.activity_main_item
}