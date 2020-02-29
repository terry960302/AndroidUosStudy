package com.ritier.a20200228_neumorphism

import android.graphics.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

//    private fun createShadowBitmap(originalBitmap: Bitmap): Bitmap? {
//        val blurFilter = BlurMaskFilter(5.0f, BlurMaskFilter.Blur.OUTER)
//        val shadowPaint = Paint()
//        shadowPaint.setMaskFilter(blurFilter)
//        val offsetXY = IntArray(2)
//        val shadowImage = originalBitmap.extractAlpha(shadowPaint, offsetXY)
//        /* Need to convert shadowImage from 8-bit to ARGB here. */
//        val shadowImage32 = shadowImage.copy(Bitmap.Config.ARGB_8888, true)
//        val c = Canvas(shadowImage32)
//        c.drawBitmap(originalBitmap,  -offsetXY[0], -offsetXY[1])
//        return shadowImage32
//    }
}
