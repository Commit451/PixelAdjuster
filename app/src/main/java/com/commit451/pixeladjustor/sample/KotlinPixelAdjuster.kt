package com.commit451.pixeladjustor.sample

import android.graphics.Bitmap
import android.graphics.Color

/**
 * A Kotlin version, for comparisons sake
 */
object KotlinPixelAdjuster {

    /**
     * Decodes a bitmap, replacing the color specified with the other color, while still maintaining alpha. Apparently
     * you cannot really do this with Color filters :(
     *
     * @param replaceColor the color to replace (no alpha)
     * @param desiredColor the color desired (no alpha)
     * @return the modified bitmap
     */
    fun adjustColor(icon: Bitmap, replaceColor: Int, desiredColor: Int): Bitmap {
        if (!icon.isMutable) {
            throw IllegalArgumentException("Bitmap must be mutable")
        }
        val pixels = IntArray(icon.height * icon.width)
        icon.getPixels(pixels, 0, icon.width, 0, 0, icon.width, icon.height)
        for (i in pixels.indices) {
            if (matchesIgnoringAlpha(pixels[i], replaceColor)) {
                pixels[i] = replaceRGBParts(pixels[i], desiredColor)
            }
        }
        icon.setPixels(pixels, 0, icon.width, 0, 0, icon.width, icon.height)
        return icon
    }

    private fun matchesIgnoringAlpha(color1: Int, color2: Int): Boolean {
        return (Color.red(color1) == Color.red(color2)
                && Color.green(color1) == Color.green(color2)
                && Color.blue(color1) == Color.blue(color2))
    }

    private fun replaceRGBParts(currentColor: Int, desiredColor: Int): Int {
        return Color.argb(Color.alpha(currentColor), Color.red(desiredColor), Color.green(desiredColor), Color.blue(desiredColor))

    }
}
