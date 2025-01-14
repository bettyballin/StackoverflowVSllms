import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyResponseHandler extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        // Some condition where you want to end the response early
        boolean someCondition = true;
        if (someCondition) {
            out.println("Ending response early.");
            response.flushBuffer();  // Flushes the buffer and sends output
            return;  // Return early, effectively ending the current request processing
        }
        
        out.println("Continue with the rest of the response...");
        out.println("</body></html>");
    }

    public static void main(String[] args) {
    }
}