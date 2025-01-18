// To compile and run this code, you need to include the Gson library in your classpath.
// Download the Gson library from: https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar
// Compile:
// javac -cp .;gson-2.10.1.jar PreferenceExample.java   (Windows)
// javac -cp .:gson-2.10.1.jar PreferenceExample.java   (Unix/Linux/macOS)
// Run:
// java -cp .;gson-2.10.1.jar PreferenceExample         (Windows)
// java -cp .:gson-2.10.1.jar PreferenceExample         (Unix/Linux/macOS)

import java.util.*;
import java.util.prefs.Preferences;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class PreferenceExample {
    public static final String USER_INPUTS_PREF = "USER_INPUTS_PREF";

    public static void main(String[] args) {
        // Saving preferences:
        List<String> userInputList = Arrays.asList("item1", "item2");
        Gson gson = new Gson();
        String serializedStr = gson.toJson(userInputList);
        Preferences prefs = Preferences.userNodeForPackage(PreferenceExample.class); // Get an instance of your preferences
        prefs.put(USER_INPUTS_PREF, serializedStr);

        // Reading back preferences:
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        String retrievedJsonPrefs = prefs.get(USER_INPUTS_PREF, null);
        List<String> loadedUserInputs = gson.fromJson(retrievedJsonPrefs, listType);

        // Output the loaded preferences
        System.out.println("Loaded User Inputs: " + loadedUserInputs);
    }
}