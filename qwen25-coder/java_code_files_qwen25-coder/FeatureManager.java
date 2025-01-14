import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FeatureManager {
    private Map<String, Set<String>> featureTiers;
    private User user;

    public FeatureManager(User user) {
        this.user = user;
        initializeFeatureTiers();
    }

    // Initialize the available features per tier
    private void initializeFeatureTiers() {
        featureTiers = new HashMap<>();

        Set<String> liteFeatures = new HashSet<>(Set.of("basic_report", "simple_notifications"));
        Set<String> normalFeatures = new HashSet<>(liteFeatures);
        normalFeatures.add("advanced_search");
        Set<String> ultimateFeatures = new HashSet<>(normalFeatures);
        ultimateFeatures.add("AI_analytics");

        featureTiers.put("Lite", liteFeatures);
        featureTiers.put("Normal", normalFeatures);
        featureTiers.put("Ultimate", ultimateFeatures);
    }

    // Check if user can access a specific feature
    public boolean hasAccess(String feature) {
        String tier = user.getSubscriptionTier();
        Set<String> availableFeatures = featureTiers.get(tier);
        return availableFeatures != null && availableFeatures.contains(feature);
    }

    public static void main(String[] args) {
        User user = new User("Normal");
        FeatureManager fm = new FeatureManager(user);

        String featureToCheck = "advanced_search";
        if (fm.hasAccess(featureToCheck)) {
            System.out.println("User has access to " + featureToCheck);
        } else {
            System.out.println("User does not have access to " + featureToCheck);
        }
    }
}

class User {
    private String subscriptionTier;

    public User(String subscriptionTier) {
        this.subscriptionTier = subscriptionTier;
    }

    public String getSubscriptionTier() {
        return subscriptionTier;
    }
}