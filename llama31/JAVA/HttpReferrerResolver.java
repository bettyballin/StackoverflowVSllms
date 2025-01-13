import javax.servlet.http.HttpServletRequest;

public class HttpReferrerResolver {
    public static void main(String[] args) {
        // Example usage:
        HttpServletRequest request = null; // This should be obtained from a servlet container
        String referrer = getReferrer(request);
        if (referrer != null) {
            System.out.println("Referrer: " + referrer);
            // Use the referrer URI
        } else {
            System.out.println("Referrer is unknown");
            // Handle the case where the referrer is unknown
        }
    }

    public static String getReferrer(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        return request.getHeader("referer");
    }
}