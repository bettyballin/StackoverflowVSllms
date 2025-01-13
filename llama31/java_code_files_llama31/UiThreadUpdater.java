/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
import android.os.Handler;
import android.os.Looper;

public class UiThreadUpdater {
    public UiThreadUpdater() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable(this){

            @Override
            public void run() {
            }
        });
    }

    public static void main(String[] stringArray) {
        new UiThreadUpdater();
    }
}
