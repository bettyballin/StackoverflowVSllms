import com.google.appengine.api.datastore.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataViewerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Data Viewer</h1><ul>");

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query query = new Query("YourEntityKind"); // Replace with your entity kind
        PreparedQuery results = datastore.prepare(query);

        for (Entity entity : results.asIterable()) {
            resp.getWriter().println("<li>" + entity.getKey() + ": " + entity.getProperty("someProperty") + "</li>");
        }

        resp.getWriter().println("</ul>");
    }

    public static void main(String[] args) {
    }
}