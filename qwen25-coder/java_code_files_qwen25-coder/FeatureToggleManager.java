import java.lang.String;
import java.util.HashMap;
import java.util.Map;
// Example of a simple feature toggle implementation in Java

public class FeatureToggleManager {
    private final Map<String, Boolean> featureToggles = new HashMap<>();

    public void enableFeature(String featureName) {
        featureToggles.put(featureName, true);
    }

    public void disableFeature(String featureName) {
        featureToggles.remove(featureName);
    }

    public boolean isFeatureEnabled(String featureName) {
        return featureToggles.getOrDefault(featureName, false);
    }
}

// Usage in code
public class MainApp {
    public static void main(String[] args) {
        FeatureToggleManager featureToggleManager = new FeatureToggleManager();

        // Enable the feature
        featureToggleManager.enableFeature("NEW_FEATURE");

        if (featureToggleManager.isFeatureEnabled("NEW_FEATURE")) {
            // Code for new feature
            System.out.println("New feature is enabled.");
        } else {
            // Code for old feature
            System.out.println("New feature is not enabled.");
        }
    }
}