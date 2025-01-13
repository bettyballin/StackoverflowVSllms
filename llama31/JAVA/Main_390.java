// Stub HttpServletRequest for compilation purposes
class HttpServletRequest {
    public String getRequestURI() {
        return "/path/to/resource";
    }

    public String getQueryString() {
        return "param1=value1&param2=value2#label";
    }
}

public class Main_390 {
    public static void main(String[] args) {
        HttpServletRequest request = new HttpServletRequest(); // Using our stub for demonstration

        if (request != null) {
            String requestURI = request.getRequestURI();
            String queryString = request.getQueryString();

            // Reconstruct the full URL
            String fullURL = requestURI + "?" + queryString;

            // Find the index of the "#" character
            int fragmentIndex = fullURL.indexOf("#");

            if (fragmentIndex != -1) {
                // Extract the label value
                String label = fullURL.substring(fragmentIndex + 1);
                // Use the label value as needed
                System.out.println(label);
            }
        } else {
            System.out.println("HttpServletRequest object is null");
        }
    }
}