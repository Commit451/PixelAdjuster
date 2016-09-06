package com.commit451.pixeladjuster;

import android.graphics.Bitmap;

/**
 * Adjusts pixels in a bitmap
 */
public class PixelAdjuster {

    // Used to load the 'pixeladjuster' library on application startup.
    static {
        System.loadLibrary("pixeladjuster");
    }

    public static boolean adjustColor(Bitmap bitmap, int replaceColor, int desiredColor) {
        return nativeAdjustBitmap(bitmap, replaceColor, desiredColor);
    }

    /**
     * A native method that is implemented by the 'pixeladjuster' native library,
     * which is packaged with this application.
     */
    private static native boolean nativeAdjustBitmap(Bitmap bitmap, int replaceColor, int desiredColor);
}
