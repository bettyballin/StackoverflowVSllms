import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private Context context;

    public SharedPreferencesManager(Context context) {
        this.context = context;
    }

    public void storeValues() {
        // Get the SharedPreferences instance
        SharedPreferences prefs = context.getSharedPreferences("your_app_name", Context.MODE_PRIVATE);

        // Store values
        prefs.edit().putString("username", "johnDoe").apply();
        prefs.edit().putString("password", "myPassword").apply();
        prefs.edit().putBoolean("some_setting", true).apply();
    }

    public void retrieveValues() {
        // Get the SharedPreferences instance
        SharedPreferences prefs = context.getSharedPreferences("your_app_name", Context.MODE_PRIVATE);

        // Retrieve values
        String username = prefs.getString("username", "");
        String password = prefs.getString("password", "");
        boolean someSetting = prefs.getBoolean("some_setting", false);

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Some Setting: " + someSetting);
    }

    public static void main(String[] args) {
        // You need to run this code in an Android environment, not on a regular Java environment.
        // For demonstration purposes, this code is being run with a mock context.
        Context context = new MockContext();
        SharedPreferencesManager manager = new SharedPreferencesManager(context);
        manager.storeValues();
        manager.retrieveValues();
    }
}

// A mock Context class for demonstration purposes.
class MockContext extends android.content.Context {
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return new MockSharedPreferences(name, mode);
    }
}

// A mock SharedPreferences class for demonstration purposes.
class MockSharedPreferences implements SharedPreferences {
    private String name;
    private int mode;

    public MockSharedPreferences(String name, int mode) {
        this.name = name;
        this.mode = mode;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public Editor edit() {
        return new MockEditor();
    }

    @Override
    public Map<String, ?> getAll() {
        return null;
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return defValue;
    }

    @Override
    public float getFloat(String key, float defValue) {
        return defValue;
    }

    @Override
    public int getInt(String key, int defValue) {
        return defValue;
    }

    @Override
    public long getLong(String key, long defValue) {
        return defValue;
    }

    @Override
    public String getString(String key, String defValue) {
        return defValue;
    }

    @Override
    public Set<String> getStringSet(String key, Set<String> defValues) {
        return defValues;
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {

    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {

    }

    class MockEditor implements Editor {
        @Override
        public Editor putString(String key, String value) {
            return this;
        }

        @Override
        public Editor putStringSet(String key, Set<String> values) {
            return this;
        }

        @Override
        public Editor putInt(String key, int value) {
            return this;
        }

        @Override
        public Editor putLong(String key, long value) {
            return this;
        }

        @Override
        public Editor putFloat(String key, float value) {
            return this;
        }

        @Override
        public Editor putBoolean(String key, boolean value) {
            return this;
        }

        @Override
        public Editor remove(String key) {
            return this;
        }

        @Override
        public Editor clear() {
            return this;
        }

        @Override
        public boolean commit() {
            return true;
        }

        @Override
        public void apply() {

        }
    }
}