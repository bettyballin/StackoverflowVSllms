import java.util.Map;

public class WebResponseExtractor {
    private byte[] responseBytes;
    private Map<String, String> headers;

    public WebResponseExtractor(WrappedResponse wrappedResponse) {
        this.responseBytes = wrappedResponse.getResponseBytes();
        this.headers = wrappedResponse.getHeaders();
    }

    public static void main(String[] args) {
        // You will need to create an instance of WrappedResponse to use this class
        // For example:
        // WrappedResponse wrappedResponse = new WrappedResponse();
        // WebResponseExtractor extractor = new WebResponseExtractor(wrappedResponse);
    }
}

// You will need to define the WrappedResponse class
class WrappedResponse {
    public byte[] getResponseBytes() {
        // implement this method to return the response bytes
        return null;
    }

    public Map<String, String> getHeaders() {
        // implement this method to return the headers
        return null;
    }
}