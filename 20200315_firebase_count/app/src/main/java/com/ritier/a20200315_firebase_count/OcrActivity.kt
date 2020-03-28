package com.ritier.a20200315_firebase_count

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.text.FirebaseVisionText
import java.util.regex.Pattern

class OcrActivity : AppCompatActivity() {

    private lateinit var ivCard : ImageView
    private lateinit var tvExtracted : TextView
    private lateinit var btnExtract : Button
    private val RC_GALLERY = 1001
    var isEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ocr)

        ivCard = findViewById(R.id.iv_card)
        tvExtracted = findViewById(R.id.tv_extracted)
        btnExtract = findViewById(R.id.btn_extract)

        ivCard.setOnClickListener {
            selectImage()
        }

        btnExtract.setOnClickListener {
            startRecognize()
        }


    }

    private fun selectImage(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_PICK
        startActivityForResult(intent, RC_GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_GALLERY){
            if(resultCode == Activity.RESULT_OK){
                val galleryImageUri = data?.data
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, galleryImageUri)
                ivCard.setImageBitmap(bitmap)
                isEnabled = true
            }else{
                Toast.makeText(this, "갤러리가 중지되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startRecognize(){
        if(isEnabled){
            tvExtracted.text = ""
            val bitmap = (ivCard.drawable as BitmapDrawable).bitmap
            val image = FirebaseVisionImage.fromBitmap(bitmap)
            val detector = FirebaseVision.getInstance().onDeviceTextRecognizer

            detector.processImage(image)
                .addOnSuccessListener {
                    processResultText(it)
                }.addOnFailureListener {
                    tvExtracted.text = "실패했습니다."
               }

        }else{
            Toast.makeText(this, "이미지가 없습니다.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun processResultText(resultText: FirebaseVisionText) {
        if (resultText.textBlocks.size == 0) {
            tvExtracted.text = "인식된 글자가 없습니다."
            return
        }
        for (block in resultText.textBlocks) {
            val blockText = block.text
            tvExtracted.append(blockText + "\n")

            val regex = "^[0-9][0-9][0-9][0-9] [0-9][0-9][0-9][0-9] [0-9][0-9][0-9][0-9] [0-9][0-9][0-9][0-9]$"
            if(Pattern.matches(regex, blockText)){
                Toast.makeText(this, "카드번호 : $blockText", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
