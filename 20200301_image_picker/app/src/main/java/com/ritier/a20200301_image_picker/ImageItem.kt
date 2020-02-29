package com.ritier.a20200301_image_picker

import android.graphics.Bitmap
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_main_item.view.*

class ImageItem(val image : Bitmap) : Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.iv_gallery.setImageBitmap(image)
    }

    override fun getLayout(): Int = R.layout.activity_main_item

}