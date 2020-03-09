package com.ritier.a20200301_image_picker

import android.app.Activity
import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder

class MainActivity : AppCompatActivity() {

    lateinit var btn_image: FloatingActionButton
    lateinit var rv_images: RecyclerView
    lateinit var adapter: GroupAdapter<GroupieViewHolder>

    val RC_GALLERY = 1001
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "이미지 가져오기"

        btn_image = findViewById(R.id.btn_image)
        rv_images = findViewById(R.id.rv_images)

        initRecyclerView()

        btn_image.setOnClickListener {
            goToGallery()
        }
    }

    private fun goToGallery(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(intent, RC_GALLERY)
    }

    private fun initRecyclerView() {
        rv_images.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        adapter = GroupAdapter()
        rv_images.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_GALLERY) {
            if (resultCode == Activity.RESULT_OK) {
                val images = data?.clipData
                if(images != null){
                    for(i in 0 until images.itemCount){
                        val imageUri = images.getItemAt(i).uri
                        val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
                        adapter.add(ImageItem(bitmap))
                    }
//                    adapter.notifyDataSetChanged()
                }else{
                    Log.e(TAG, "이미지를 가져오는데 에러가 있습니다.")
                }
            } else {
                Toast.makeText(this, "갤러리 접근이 중지되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
