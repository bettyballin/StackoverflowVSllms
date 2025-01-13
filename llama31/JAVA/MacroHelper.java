import java.lang.String;
import java.lang.StringBuilder;

// Assuming Request is a custom class, you need to import it or define it in the same package
// If it's not a custom class, you need to use the correct fully qualified name
import your.package.Request;

public class MacroHelper {
    public static String showObjectErrors(String objectName, Request request) {
        if (request.errorSystem.hasErrors(objectName)) {
            StringBuilder errors = new StringBuilder("<table>");
            for (String error : request.errorSystem.getErrors(objectName)) {
                errors.append("<tr><td class='acError'>").append(error).append("</td></tr>");
            }
            errors.append("</table>");
            return errors.toString();
        }
        return "";
    }
    // Other macro methods...

    public static void main(String[] args) {
        // You may want to create an instance of Request and test the showObjectErrors method
        // Request request = new Request();
        // System.out.println(showObjectErrors("testObject", request));
    }
}