#include <jni.h>
#include <android/bitmap.h>
#include <android/log.h>

#define  LOG_TAG    "pixeladjusttor-native"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

extern "C"
void
Java_com_commit451_pixeladjustor_PixelAdjustor_nativeAdjustBitmap(
        JNIEnv *env,
        jobject, /* this */
        jobject bitmapOut, jint replaceColor, jint desiredColor) {

    unsigned char *pixels;
    AndroidBitmapInfo info;
    int ret;

    // Get image info
    if ((ret = AndroidBitmap_getInfo(env, bitmapOut, &info)) != 0) {
        LOGE("AndroidBitmap_getInfo() failed ! error=%d", ret);
        return;
    }

    if (info.format != ANDROID_BITMAP_FORMAT_RGBA_8888)
    {
        LOGE("Bitmap format is not RGBA_8888!");
        return;
    }

    LOGI("reading bitmap pixels...");
    void* bitmapPixels;
    if ((ret = AndroidBitmap_lockPixels(env, bitmapOut, &bitmapPixels)) < 0)
    {
        LOGE("AndroidBitmap_lockPixels() failed ! error=%d", ret);
        return;
    }

    uint32_t* src = (uint32_t*) bitmapPixels;

    int i;
    for (i = info.width * info.height - 1; i >= 0; i--) {
        src[i] = 0xffff0000;
    }

    AndroidBitmap_unlockPixels(env, bitmapOut);
}
