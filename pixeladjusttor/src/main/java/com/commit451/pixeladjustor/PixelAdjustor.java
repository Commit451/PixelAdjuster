package com.commit451.pixeladjustor;

import android.graphics.Bitmap;

/**
 * Adjusts pixels in a bitmap
 */
public class PixelAdjustor {

    // Used to load the 'pixelator' library on application startup.
    static {
        System.loadLibrary("pixeladjustor");
    }

    public static void adjustColor(Bitmap bitmap, int replaceColor, int desiredColor) {
        nativeAdjustBitmap(bitmap, replaceColor, desiredColor);
    }

    /**
     * A native method that is implemented by the 'pixelator' native library,
     * which is packaged with this application.
     */
    private static native void nativeAdjustBitmap(Bitmap bitmap, int replaceColor, int desiredColor);
}
