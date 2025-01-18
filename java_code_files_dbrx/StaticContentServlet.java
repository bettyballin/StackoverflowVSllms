import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StaticContentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String basePath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.basePath = getServletContext().getRealPath("/"); // Base path to your static files directory
        if (!this.basePath.endsWith(File.separator)) this.basePath += File.separator;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestedURI = req.getRequestURI(); // Full path within your context root, including the leading context root
        if (!requestedURI.endsWith("/")) requestedURI += File.separator;
        long lastModifiedTime = new File(basePath + requestedURI).lastModified();
        String ifModifiedSinceString = req.getHeader("If-Modified-Since"); // Support for If-Modified-Since header tag
        long ifModifiedSince = 0; // If the client doesn't send a If-Modified-Since, then assume they want whatever is on our server (which may not be the latest)
        try {
            if (ifModifiedSinceString != null && !"".equals(ifModifiedSinceString)) {
                ifModifiedSince = HttpDateParser.parseDate(ifModifiedSinceString).getTime(); // This value will always be in UTC. We don't have to worry about timezones
            }
        } catch (IllegalArgumentException e) {} // In some cases, such as invalid date provided by client, the parseDate might fail; we handle that here

        if (ifModifiedSince != 0 && !isChanged(lastModifiedTime, ifModifiedSince)) { // If the user asks for a resource and it's not changed on our server since they last requested it, then send them a `304 - Not Modified` header. That would avoid unnecessary data transfer
            resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
        } else { // Otherwise send the new/changed resource to the client along with proper headers.
            handleStaticContentRequest(req, resp);
        }
    }

    private boolean isChanged(long lastModifiedTimeOnServer, long ifModifiedSince) {
        return lastModifiedTimeOnServer > ifModifiedSince;
    }

    private void handleStaticContentRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Handle the static content request using your custom logic here.
        // You can add support for features like gzip encoding and etags as optional.
        // Some code might look similar to this: https://www.unixtutorial.org/servlet-httpservletresponse-setcontenttype
    }

    public static void main(String[] args) {
        // Main method implementation
    }

    private static class HttpDateParser {
        private static final SimpleDateFormat[] dateFormats = new SimpleDateFormat[]{
            new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US), // RFC 822, updated by RFC 1123
            new SimpleDateFormat("EEEEEE, dd-MMM-yy HH:mm:ss zzz", Locale.US), // RFC 850, obsoleted by RFC 1036
            new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy", Locale.US) // ANSI C's asctime() format
        };

        public static Date parseDate(String dateString) throws IllegalArgumentException {
            for (SimpleDateFormat dateFormat : dateFormats) {
                try {
                    return dateFormat.parse(dateString);
                } catch (ParseException e) {
                    // Try next date format
                }
            }
            throw new IllegalArgumentException("Cannot parse date: " + dateString);
        }
    }
}