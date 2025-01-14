// Interface for URL Service
public interface UrlService {
    String getUrl(String key);
}

// Implementation of UrlService in presentation layer
public class PresentationUrlServiceImpl implements UrlService {
    @Override
    public String getUrl(String key) {
        // Logic to generate URLs based on keys, possibly using templates or configurations specific to the presentation layer
        return "http://example.com/" + key;
    }
}

// Module that needs URLs
public class MessageModule {
    private final UrlService urlService;

    public MessageModule(UrlService urlService) {
        this.urlService = urlService;
    }

    public void sendMessage() {
        String url = urlService.getUrl("someKey");
        // Use URL to send out messages
        System.out.println("Sending message with URL: " + url);
    }
}

// Configuration to autowire correct implementation
public class AppConfig {
    public static void main(String[] args) {
        UrlService urlService = new PresentationUrlServiceImpl();
        MessageModule messageModule = new MessageModule(urlService);
        messageModule.sendMessage();
    }
}