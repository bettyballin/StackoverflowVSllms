import javax.servlet.http.HttpServletRequest;

public class ServletOrController {
    public String doGet(HttpServletRequest request, String dynamicContent) {
        if (request.getParameter("escaped_fragment") != null) {
            // Return the complete HTML, without Ajax
            return "<div id='dynamic-content'>" + dynamicContent + "</div>";
        } else {
            // Return the initial HTML with Ajax placeholder
            return "<div id='dynamic-content"><!-- placeholder --></div>";
        }
    }

    public static void main(String[] args) {
        // Create an instance of HttpServletRequest for testing purposes
        HttpServletRequest request = new MockHttpServletRequest();

        ServletOrController servlet = new ServletOrController();
        String dynamicContent = "Hello, World!";
        String result = servlet.doGet(request, dynamicContent);
        System.out.println(result);
    }

    static class MockHttpServletRequest implements HttpServletRequest {
        @Override
        public String getParameter(String name) {
            // Simulate the request parameter for testing
            if (name.equals("escaped_fragment")) {
                return "test";
            }
            return null;
        }

        // You need to implement other methods of HttpServletRequest
        // For simplicity, let's just implement a few required methods
        @Override
        public String getMethod() {
            return "GET";
        }

        @Override
        public String getRequestURI() {
            return "/test";
        }

        @Override
        public String getServletPath() {
            return "/test";
        }

        @Override
        public String getPathInfo() {
            return null;
        }

        @Override
        public String getQueryString() {
            return null;
        }

        @Override
        public String getProtocol() {
            return "HTTP/1.1";
        }

        @Override
        public String getScheme() {
            return "http";
        }

        @Override
        public String getServerName() {
            return "localhost";
        }

        @Override
        public int getServerPort() {
            return 80;
        }

        @Override
        public String getRemoteAddr() {
            return "127.0.0.1";
        }

        @Override
        public String getRemoteHost() {
            return "localhost";
        }

        @Override
        public int getRemotePort() {
            return 1234;
        }

        @Override
        public String getLocalAddr() {
            return "127.0.0.1";
        }

        @Override
        public String getLocalName() {
            return "localhost";
        }

        @Override
        public int getLocalPort() {
            return 80;
        }

        @Override
        public String getCharacterEncoding() {
            return "UTF-8";
        }

        @Override
        public int getContentLength() {
            return 0;
        }

        @Override
        public String getContentType() {
            return null;
        }

        @Override
        public String getAuthType() {
            return null;
        }

        @Override
        public String getContextPath() {
            return "";
        }

        @Override
        public String getHeader(String name) {
            return null;
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            return Collections.emptyEnumeration();
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            return Collections.emptyEnumeration();
        }

        @Override
        public int getIntHeader(String name) {
            return -1;
        }

        @Override
        public String getLocale() {
            return Locale.getDefault().toString();
        }

        @Override
        public Enumeration<Locale> getLocales() {
            return Collections.emptyEnumeration();
        }

        @Override
        public boolean isSecure() {
            return false;
        }

        @Override
        public Cookie[] getCookies() {
            return null;
        }

        @Override
        public long getDateHeader(String name) {
            return -1;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return Collections.emptyMap();
        }

        @Override
        public Enumeration<String> getParameterNames() {
            return Collections.emptyEnumeration();
        }

        @Override
        public String[] getParameterValues(String name) {
            return new String[0];
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return null;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return null;
        }

        @Override
        public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
        }

        @Override
        public void setAttribute(String name, Object o) {
        }

        @Override
        public void removeAttribute(String name) {
        }

        @Override
        public Locale getPreferredLocales() {
            return Locale.getDefault();
        }

        @Override
        public Map<String, String> getTrailerFields() {
            return Collections.emptyMap();
        }

        @Override
        public boolean isTrailerFieldsReady() {
            return false;
        }
    }
}