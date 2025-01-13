import java.lang.String;

public class RequestAnalyzer {
    public static void main(String[] args) {
        // Create an instance of the class to access non-static fields and methods
        RequestAnalyzer analyzer = new RequestAnalyzer();
        analyzer.analyzeRequest();
    }

    private void analyzeRequest() {
        // Assuming 'request' is an instance of HttpServletRequest
        // For demonstration purposes, we'll create a mock request object
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Accept", "application/json");

        String acceptHeader = request.getHeader("Accept");
        if (acceptHeader.contains("application/json") || acceptHeader.contains("application/xml")) {
            // Request was likely made via AJAX
            System.out.println("Request was likely made via AJAX");
        }
    }

    // Mock implementation of HttpServletRequest for demonstration purposes
    private static class MockHttpServletRequest {
        private java.util.HashMap<String, String> headers = new java.util.HashMap<>();

        public void addHeader(String name, String value) {
            headers.put(name, value);
        }

        public String getHeader(String name) {
            return headers.get(name);
        }
    }
}