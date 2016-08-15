package com.commit451.pixeladjustor;

/**
 * Adjusts pixels in a bitmap
 */
public class PixelAdjustor {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public static String fromJni() {
        return stringFromJNI();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private static native String stringFromJNI();
}
