package com.commit451.pixeladjustor.sample;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * A java version, for comparisons sake
 */
public class JavaPixelAdjuster {

    /**
     * Decodes a bitmap, replacing the color specified with the other color, while still maintaining alpha. Apparently
     * you cannot really do this with Color filters :(
     * @param replaceColor the color to replace (no alpha)
     * @param desiredColor the color desired (no alpha)
     * @return the modified bitmap
     */
    public static Bitmap adjustColor(Bitmap icon, int replaceColor, int desiredColor) {
        if (!icon.isMutable()) {
            throw new IllegalArgumentException("Bitmap must be mutable");
        }
        int[] pixels = new int[icon.getHeight() * icon.getWidth()];
        icon.getPixels(pixels, 0, icon.getWidth(), 0, 0, icon.getWidth(), icon.getHeight());
        for (int i = 0; i < pixels.length; i++) {
            if (matchesIgnoringAlpha(pixels[i], replaceColor)) {
                pixels[i] = replaceRGBParts(pixels[i], desiredColor);
            }
        }
        icon.setPixels(pixels, 0, icon.getWidth(), 0, 0, icon.getWidth(), icon.getHeight());
        return icon;
    }

    private static boolean matchesIgnoringAlpha(int color1, int color2) {
        return Color.red(color1) == Color.red(color2)
                && Color.green(color1) == Color.green(color2)
                && Color.blue(color1) == Color.blue(color2);
    }

    private static int replaceRGBParts(int currentColor, int desiredColor) {
        return Color.argb(Color.alpha(currentColor), Color.red(desiredColor), Color.green(desiredColor), Color.blue(desiredColor));

    }
}
