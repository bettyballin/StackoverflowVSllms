interface UrlGenerator {
    String getUserProfileUrl(long userId);
}

public class PresentationLayerUrlGenerator implements UrlGenerator {
    @Override
    public String getUserProfileUrl(long userId) {
        // Generate and return user profile URL based on your implementation
        return null; // Placeholder return to make the code compile
    }
}