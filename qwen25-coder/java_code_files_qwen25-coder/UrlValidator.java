public class UrlValidator {

    public static boolean isValidUrl(String url) {
        // Define the maximum allowed length for the URL
        final int MAX_URL_LENGTH = 256; // Example value, adjust according to your needs

        // Check if the URL is not null, not longer than max length, and follows expected pattern
        return url != null && url.length() <= MAX_URL_LENGTH && url.matches("https?://www\\.example\\.com/.+");
    }

    public static void main(String[] args) {
        // Usage example
        String testUrl = "http://www.example.com/some_url/some_parameter/some_keyword";
        if (isValidUrl(testUrl)) {
            System.out.println("URL is valid.");
        } else {
            System.out.println("Invalid URL.");
        }
    }
}