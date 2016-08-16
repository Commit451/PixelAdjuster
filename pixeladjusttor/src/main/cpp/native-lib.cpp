#include <jni.h>
#include <android/bitmap.h>

extern "C"
void
Java_com_commit451_pixeladjustor_PixelAdjustor_nativeAdjustBitmap(
        JNIEnv *env,
        jobject, /* this */
        jobject bitmapOut, jint replaceColor, jint desiredColor) {

    AndroidBitmapInfo infoOut;

    int ret;
    // Get image info
    if ((ret = AndroidBitmap_getInfo(env, bitmapOut, &infoOut)) != 0) {
        return;
    }
}
