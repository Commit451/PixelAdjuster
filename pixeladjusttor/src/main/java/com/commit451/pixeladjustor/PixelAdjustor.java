package com.commit451.pixeladjustor;

import android.graphics.Bitmap;

/**
 * Adjusts pixels in a bitmap
 */
public class PixelAdjustor {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public static void adjustColor(Bitmap bitmap, int replaceColor, int desiredColor) {
        nativeAdjustBitmap(bitmap, replaceColor, desiredColor);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private static native void nativeAdjustBitmap(Bitmap bitmap, int replaceColor, int desiredColor);
}
