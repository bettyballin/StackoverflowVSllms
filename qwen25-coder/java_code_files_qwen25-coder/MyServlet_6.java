import java.lang.String;
// Example of explicit synchronization

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class MyServlet_6 extends HttpServlet {
    private final Object lock = new Object();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        synchronized (lock) {
            // Process request, ensuring thread safety for shared resources
        }
    }

    public static void main(String[] args) {
    }
}