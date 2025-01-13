import android.content.SharedPreferences;
import android.content.Context;

public class SettingsManager {
    private Context context;

    public SettingsManager(Context context) {
        this.context = context;
    }

    public SharedPreferences getPrefs() {
        return context.getSharedPreferences("your_app_name_settings", Context.MODE_PRIVATE);
    }

    public static void main(String[] args) {
        // You need to run this code on an Android device or emulator.
        // The SharedPreferences class is part of the Android SDK, not standard Java.
        // You can't use it in a standard Java program.
    }
}