import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URLEncoder;

public class FormProcessorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process your form data here
        String var1 = "a"; // Example variable
        String var2 = "b"; // Another example variable

        // Redirect with query parameters
        response.sendRedirect("index.html?var1=" + URLEncoder.encode(var1, "UTF-8") + "&var2=" + URLEncoder.encode(var2, "UTF-8"));
    }
    public static void main(String[] args) {
    }
}