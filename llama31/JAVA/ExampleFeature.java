// Define the FeatureToggle enum
public enum FeatureToggle {
    LITE,
    NORMAL,
    ULTIMATE
}

// Define the Feature interface
interface Feature {
    boolean isEnabled(FeatureToggle toggle);
}

// Define the ExampleFeature class
class ExampleFeature implements Feature {
    @Override
    public boolean isEnabled(FeatureToggle toggle) {
        return toggle == FeatureToggle.NORMAL || toggle == FeatureToggle.ULTIMATE;
    }
}

// Define the AppConfig class
class AppConfig {
    private FeatureToggle toggle;

    public AppConfig(FeatureToggle toggle) {
        this.toggle = toggle;
    }

    public boolean isFeatureEnabled(Feature feature) {
        return feature.isEnabled(toggle);
    }
}

// Define the ExampleService class with the main method
public class ExampleService {
    private final ExampleFeature feature;

    public ExampleService(AppConfig config) {
        if (config.isFeatureEnabled(new ExampleFeature())) {
            feature = new ExampleFeature();
        } else {
            feature = null;
        }
    }

    public static void main(String[] args) {
        // Create an instance of AppConfig with the NORMAL feature toggle
        AppConfig config = new AppConfig(FeatureToggle.NORMAL);

        // Create an instance of ExampleService with the AppConfig
        ExampleService service = new ExampleService(config);
    }
}