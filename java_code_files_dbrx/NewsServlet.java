import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/sse/*") // This creates URL like /projectname/news?id=134 (this must be unique per user to avoid caching)
public class NewsServlet extends HttpServlet implements SingleThreadModel {
    private final Map<String, PrintWriter> writers = new HashMap<>();
    private long lastUpdate = System.currentTimeMillis();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        // Prevent caching of event data:
        String accept = request.getHeader("Accept"); // Content negotiation (MIME type) at client-side

        if (accept != null && accept.contains("text/event-stream")) {
            response.setContentType("text/event-stream");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return; // Browsers with no JS support can be sent a 404 error
        }

        // Event stream must not be cacheable by server (Cache-Control) or client (META=PRAGMA|X-UA-COMPATIBLE):
        response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate"); // HTTP 1.1:
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0. Also used for Google Chrome workaround (HTTP spec violation).
        response.setDateHeader("Expires", -1); // Proxies. Set to past date.
        response.setCharacterEncoding("utf-8"); // Other encodings are allowed but less widely supported.

        // To maintain the permanent connection, a thread is waiting to send the new messages to user (this is singleThread Model servlet so it won't deadlock):
        new Performer().start(); // Now open a line:

        String uri = request.getRequestURI(); /* This gives us the path to the current resource from root of server context: projectname/news?id=134 */

        PrintWriter writer = response.getWriter(); // Writer for sending data back to client:
        writers.put(uri, writer); /* We want each feed stream going out here mapped directly to a single user session on the system so we can use this key later*/
    }

    // A threaded actor that sends SSE events:
    class Performer extends Thread {
        public void run() {
            try {
                for (;;) {
                    sleep(10 * 1000); // Wait 10 seconds then update our subscribers with some new messages
                    synchronized (writers) {
                        for (PrintWriter writer : writers.values()) {
                            writer.println(
                                "retry: " +
                                Integer.toString((short) 1) +
                                "\n" +
                                "elapsed: " +
                                Long.toString(System.currentTimeMillis() - lastUpdate) +
                                "; " + // How long since last event
                                "data: {\"user\": 0, \"news\" : [\"Hey a new News\", \"A Second One!\"]}"
                            );
                            writer.flush();
                        }
                    }
                }
            } catch (InterruptedException e) {
                // Handle interruption
            }
        }
    }
}