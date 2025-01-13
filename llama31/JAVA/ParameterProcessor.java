import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

public class ParameterProcessor {
    // In your Servlet's doPost() method
    public static void processParameters(HttpServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            // Process the paramValues array
        }
    }

    public static void main(String[] args) {
        // You would need to create an HttpServletRequest object to use processParameters method
        // For example, in a Servlet environment:
        // HttpServletRequest request = ...;
        // processParameters(request);
    }
}