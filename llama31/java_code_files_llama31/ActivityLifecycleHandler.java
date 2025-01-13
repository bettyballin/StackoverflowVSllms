/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
import android.app.Activity;

public class ActivityLifecycleHandler
extends Activity {
    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
        this.finish();
    }

    public static void main(String[] stringArray) {
    }
}
