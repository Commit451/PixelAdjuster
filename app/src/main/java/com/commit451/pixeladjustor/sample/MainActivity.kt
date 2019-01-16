package com.commit451.pixeladjustor.sample

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle

import com.commit451.pixeladjuster.PixelAdjuster

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val opts = BitmapFactory.Options()
        opts.inMutable = true
        val image = BitmapFactory.decodeResource(resources, R.drawable.horizon, opts)

        var startTime = System.currentTimeMillis()
        KotlinPixelAdjuster.adjustColor(image, Color.WHITE, Color.MAGENTA)

        textKotlin.text = "Kotlin Time taken: ${(System.currentTimeMillis() - startTime)} ms"
        imageKotlin.setImageBitmap(image)

        val image2 = BitmapFactory.decodeResource(resources, R.drawable.horizon, opts)

        startTime = System.currentTimeMillis()
        PixelAdjuster.adjustColor(image2, Color.WHITE, Color.MAGENTA)
        textNdk.text = "NDK Time taken: ${(System.currentTimeMillis() - startTime)} ms"
        imageNdk.setImageBitmap(image2)
    }


}
