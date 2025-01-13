import javax.inject.Inject;

interface UrlGenerator {
    String generateUrl(String path);
}

// backend-module
public class MessageSender_1_1 {
    private final UrlGenerator urlGenerator;
    
    @Inject
    public MessageSender_1(UrlGenerator urlGenerator) {
        this.urlGenerator = urlGenerator;
    }
    
    public void sendMessage() {
        String url = urlGenerator.generateUrl("message-path");
        // Use the generated URL to send the message
    }

    public static void main(String[] args) {
    }
}