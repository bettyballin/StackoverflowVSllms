/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.view.View
 *  android.view.Window
 */
import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;

public class ScreenshotTaker {
    public static void main(String[] stringArray) {
    }

    public static void takeScreenshot(View view, Window window) {
        view = window.getDecorView().getRootView();
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap((Bitmap)view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
    }
}
