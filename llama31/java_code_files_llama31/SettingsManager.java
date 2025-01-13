/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 */
import android.content.Context;
import android.content.SharedPreferences;

public class SettingsManager {
    private Context context;

    public SettingsManager(Context context) {
        this.context = context;
    }

    public SharedPreferences getPrefs() {
        return this.context.getSharedPreferences("your_app_name_settings", 0);
    }

    public static void main(String[] stringArray) {
    }
}
