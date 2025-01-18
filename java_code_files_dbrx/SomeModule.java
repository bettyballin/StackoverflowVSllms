public class SomeModule {
    private final UrlGenerator urlGenerator;  // Inject an implementation at runtime
    private String userId;  // Assume userId is a field

    public SomeModule(UrlGenerator urlGenerator) {
        this.urlGenerator = urlGenerator;
    }

    public void sendMessage() {
        String userProfileUrl = urlGenerator.getUserProfileUrl(userId);
        // ...
    }

    interface UrlGenerator {
        String getUserProfileUrl(String userId);
    }
}