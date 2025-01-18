import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper {

    private String requestedURL;

    public RequestWrapper(HttpServletRequest request) {
        super(request);
        // Initialize requestedURL based on request
        this.requestedURL = request.getRequestURI();
        // Example logic to distinguish admin or non-admin path
        if (this.requestedURL.indexOf("/admin/") >= 0) {
            // Additional logic for admin paths if needed
        }
        // Use methods like getMethod(), getProtocol() as per your needs
    }

    @Override
    public String getServletPath(){
        return requestedURL; // Now you have access to original URL request information inside the servlet with this variable
    }

    // Other methods can be overridden or added as needed
}