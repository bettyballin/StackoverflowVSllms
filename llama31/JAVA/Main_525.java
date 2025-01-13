import javax.servlet.http.HttpServletRequest;

// Simple mock class for HttpServletRequest
class MockHttpServletRequest implements HttpServletRequest {
    private String method;
    private String headerName;
    private String headerValue;

    public MockHttpServletRequest(String method, String headerName, String headerValue) {
        this.method = method;
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public String getHeader(String name) {
        if (name.equals(this.headerName)) {
            return this.headerValue;
        }
        return null;
    }

    // Implement other methods as needed or leave them unimplemented for this simple mock
    @Override
    public String getAuthType() { return null; }
    @Override
    public String getContextPath() { return null; }
    @Override
    public Cookie[] getCookies() { return null; }
    @Override
    public long getDateHeader(String name) { return 0; }
    @Override
    public String getHeaderNames() { return null; }
    @Override
    public int getIntHeader(String name) { return 0; }
    @Override
    public String getPathInfo() { return null; }
    @Override
    public String getPathTranslated() { return null; }
    @Override
    public String getQueryString() { return null; }
    @Override
    public String getRemoteUser() { return null; }
    @Override
    public String getRequestURI() { return null; }
    @Override
    public StringBuffer getRequestURL() { return null; }
    @Override
    public String getRequestedSessionId() { return null; }
    @Override
    public String getServletPath() { return null; }
    @Override
    public HttpSession getSession() { return null; }
    @Override
    public HttpSession getSession(boolean create) { return null; }
    @Override
    public Principal getUserPrincipal() { return null; }
    @Override
    public boolean isRequestedSessionIdFromCookie() { return false; }
    @Override
    public boolean isRequestedSessionIdFromURL() { return false; }
    @Override
    public boolean isRequestedSessionIdValid() { return false; }
    @Override
    public boolean isUserInRole(String role) { return false; }
}

public class Main_525 {
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String xRequestedWith = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(xRequestedWith)) {
            return true;
        }
        String acceptHeader = request.getHeader("Accept");
        if (acceptHeader != null && acceptHeader.contains("application/json")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Creating a mock HttpServletRequest for testing
        HttpServletRequest request1 = new MockHttpServletRequest("GET", "X-Requested-With", "XMLHttpRequest");
        HttpServletRequest request2 = new MockHttpServletRequest("POST", "Accept", "application/json");
        HttpServletRequest request3 = new MockHttpServletRequest("POST", "Accept", "text/plain");

        System.out.println(isAjaxRequest(request1)); // Should print: true
        System.out.println(isAjaxRequest(request2)); // Should print: true
        System.out.println(isAjaxRequest(request3)); // Should print: false
    }
}