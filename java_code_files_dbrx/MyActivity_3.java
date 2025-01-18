import java.util.HashMap;
import java.util.Map;

public class MyActivity {

    public static final int MODE_PRIVATE = 0;

    private SharedPreferences preferences;

    public MyActivity() {
        preferences = new SharedPreferences();
    }

    public SharedPreferences getPreferences(int mode) {
        return preferences;
    }

    public void savePreferences() {
        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", "user@email.com");
        editor.putString("password", "$ecreTpa55Word123!");
        editor.commit();  // Very important to save the values.
    }

    public static void main(String[] args) {
        MyActivity activity = new MyActivity();
        activity.savePreferences();
    }

    // Mock SharedPreferences class
    public static class SharedPreferences {
        private Map<String, String> map = new HashMap<>();

        public Editor edit() {
            return new Editor(this);
        }

        public static class Editor {
            private SharedPreferences sharedPreferences;

            public Editor(SharedPreferences sharedPreferences) {
                this.sharedPreferences = sharedPreferences;
            }

            public void putString(String key, String value) {
                sharedPreferences.map.put(key, value);
            }

            public void commit() {
                // Very important to save the values.
                System.out.println("Preferences saved: " + sharedPreferences.map);
            }
        }
    }
}