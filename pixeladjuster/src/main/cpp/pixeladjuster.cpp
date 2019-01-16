#include <jni.h>
#include <android/bitmap.h>
#include <android/log.h>

#define  LOG_TAG    "pixeladjuster-native"
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

const bool DEBUG = false;

extern "C"
jboolean
Java_com_commit451_pixeladjuster_PixelAdjuster_nativeAdjustBitmap(
        JNIEnv *env,
        jobject, /* this */
        jobject bitmapOut, jint replaceColor, jint desiredColor) {

    AndroidBitmapInfo info;
    int ret;

    // Get image info
    if ((ret = AndroidBitmap_getInfo(env, bitmapOut, &info)) != 0) {
        if (DEBUG) {
            LOGE("AndroidBitmap_getInfo() failed ! error=%d", ret);
        }
        return (jboolean) false;
    }

    if (info.format != ANDROID_BITMAP_FORMAT_RGBA_8888) {
        if (DEBUG) {
            LOGE("Bitmap format is not RGBA_8888!");
        }
        return (jboolean) false;
    }

    void *bitmapPixels;
    if ((ret = AndroidBitmap_lockPixels(env, bitmapOut, &bitmapPixels)) < 0) {
        if (DEBUG) {
            LOGE("AndroidBitmap_lockPixels() failed ! error=%d", ret);
        }
        return (jboolean) false;
    }

    uint32_t *src = (uint32_t *) bitmapPixels;

    int i;
    for (i = info.width * info.height - 1; i >= 0; i--) {
        //TODO check for matching, ignoring the alpha component
        if (src[i] == replaceColor) {
            src[i] = desiredColor;
        }
    }

    AndroidBitmap_unlockPixels(env, bitmapOut);
    return (jboolean) true;
}
