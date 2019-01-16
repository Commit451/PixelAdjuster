package com.commit451.pixeladjuster

import android.graphics.Bitmap

/**
 * Adjusts pixels in a bitmap
 */
object PixelAdjuster {

    // Used to load the 'pixeladjuster' library on application startup.
    init {
        System.loadLibrary("pixeladjuster")
    }

    fun adjustColor(bitmap: Bitmap, replaceColor: Int, desiredColor: Int): Boolean {
        return nativeAdjustBitmap(bitmap, replaceColor, desiredColor)
    }

    /**
     * A native method that is implemented by the 'pixeladjuster' native library,
     * which is packaged with this application.
     */
    private external fun nativeAdjustBitmap(bitmap: Bitmap, replaceColor: Int, desiredColor: Int): Boolean
}
