import javax.servlet.http.HttpServletRequest;

public class UserAgentHandler {
    public void handleRequest(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent != null && (userAgent.contains("Googlebot") || userAgent.contains("bingbot"))) {
            // Handle search robot request
            System.out.println("Search robot request");
        } else {
            // Handle human request
            System.out.println("Human request");
        }
    }

    public static void main(String[] args) {
        // Create an instance of UserAgentHandler
        UserAgentHandler handler = new UserAgentHandler();

        // Simulate a request
        HttpServletRequest request = new HttpServletRequest() {
            @Override
            public String getHeader(String name) {
                // Simulate a user agent string
                return "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)";
            }
        };

        handler.handleRequest(request);
    }
}