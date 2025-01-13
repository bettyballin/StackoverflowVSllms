import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DynamicAttributesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> dynamicAttributes = (Map<String, Object>) req.getAttribute("dynamicAttributesVar");
        String someUnexpectedAttribute = (String) dynamicAttributes.get("someUnexpectedAttribute");
        PrintWriter out = resp.getWriter();
        out.println(someUnexpectedAttribute);
    }

    public static void main(String[] args) {
        // You would need a servlet container to run this servlet.
        // The following is a placeholder and would not actually run the servlet.
        System.out.println("This is a servlet and cannot be run directly with javac.");
    }
}