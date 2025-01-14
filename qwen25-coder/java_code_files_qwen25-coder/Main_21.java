import java.util.HashMap;

public class Main {
    // Define interfaces and implementations
    public interface SharedPreferences {
        Editor edit();
        String getString(String key, String defValue);

        interface Editor {
            Editor putString(String key, String value);
            void apply();
        }
    }

    public static class SharedPreferencesImpl implements SharedPreferences {
        private HashMap<String, String> data = new HashMap<>();

        public SharedPreferences.Editor edit() {
            return new EditorImpl(data);
        }

        public String getString(String key, String defValue) {
            String value = data.get(key);
            return (value != null) ? value : defValue;
        }

        public static class EditorImpl implements SharedPreferences.Editor {
            private HashMap<String, String> dataRef;
            private HashMap<String, String> tempData = new HashMap<>();

            public EditorImpl(HashMap<String, String> data) {
                dataRef = data;
            }

            public SharedPreferences.Editor putString(String key, String value) {
                tempData.put(key, value);
                return this;
            }

            public void apply() {
                dataRef.putAll(tempData);
                tempData.clear();
            }
        }
    }

    public static final int MODE_PRIVATE = 0;

    public static SharedPreferences getSharedPreferences(String name, int mode) {
        return new SharedPreferencesImpl();
    }

    public static void main(String[] args) {
        // To save data
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", "exampleUsername");
        editor.putString("password", "encryptedPassword"); // Ensure to encrypt before storing
        editor.apply(); // or use commit() if synchronous operation is needed

        // To retrieve data
        String savedUsername = sharedPreferences.getString("username", "");
        String savedEncryptedPassword = sharedPreferences.getString("password", "");

        // Decrypt the password when you need it in your application

        // For demonstration purposes, print the retrieved data
        System.out.println("Retrieved username: " + savedUsername);
        System.out.println("Retrieved password: " + savedEncryptedPassword);
    }
}