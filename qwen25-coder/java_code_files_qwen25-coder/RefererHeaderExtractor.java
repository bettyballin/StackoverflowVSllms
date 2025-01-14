public class RefererHeaderExtractor {

    interface Request {
        String getHeader(String name);
    }

    public void extractReferer(Request request) {
        String referrer = request.getHeader("Referer");
        if (referrer != null) {
            System.out.println("The referring page was: " + referrer);
        } else {
            System.out.println("No referring page found.");
        }
    }

    public static void main(String[] args) {
        // For testing, create an instance of Request
        Request request = new Request() {
            public String getHeader(String name) {
                // For testing purposes, return a test value
                if ("Referer".equals(name)) {
                    return "http://example.com";
                } else {
                    return null;
                }
            }
        };
        // Call extractReferer
        new RefererHeaderExtractor().extractReferer(request);
    }
}