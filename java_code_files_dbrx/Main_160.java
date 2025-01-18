// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.Cookie;
// import javax.servlet.ServletOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Object outputMessage = new MockHttpServletResponse();
        HttpServletResponse response = (HttpServletResponse) outputMessage;
        response.setHeader("Content-Disposition","inline; filename=myfilename.pdf");
        byte[] bytes = new byte[0]; // placeholder for the actual bytes
        response.addHeader("Content-Length", String.valueOf(bytes.length)); // set bytes obtained from DataHandler as content length before writing it to ServletOutputStream below for performance benefit
    }
}

class MockHttpServletResponse implements HttpServletResponse {
    @Override
    public void setHeader(String name, String value) {
        // Implementation here
    }

    @Override
    public void addHeader(String name, String value) {
        // Implementation here
    }

    // Implement all other methods of HttpServletResponse as empty methods
    @Override public void addCookie(Cookie cookie) {}
    @Override public boolean containsHeader(String name) { return false; }
    @Override public String encodeURL(String url) { return null; }
    @Override public String encodeRedirectURL(String url) { return null; }
    @Override public String encodeUrl(String url) { return null; }
    @Override public String encodeRedirectUrl(String url) { return null; }
    @Override public void sendError(int sc, String msg) throws IOException {}
    @Override public void sendError(int sc) throws IOException {}
    @Override public void sendRedirect(String location) throws IOException {}
    @Override public void setDateHeader(String name, long date) {}
    @Override public void addDateHeader(String name, long date) {}
    @Override public void setIntHeader(String name, int value) {}
    @Override public void addIntHeader(String name, int value) {}
    @Override public void setStatus(int sc) {}
    @Override public void setStatus(int sc, String sm) {}
    @Override public int getStatus() { return 0; }
    @Override public String getHeader(String name) { return null; }
    @Override public Collection<String> getHeaders(String name) { return null; }
    @Override public Collection<String> getHeaderNames() { return null; }
    @Override public String getCharacterEncoding() { return null; }
    @Override public String getContentType() { return null; }
    @Override public ServletOutputStream getOutputStream() throws IOException { return null; }
    @Override public PrintWriter getWriter() throws IOException { return null; }
    @Override public void setCharacterEncoding(String charset) {}
    @Override public void setContentLength(int len) {}
    @Override public void setContentLengthLong(long len) {}
    @Override public void setContentType(String type) {}
    @Override public void setBufferSize(int size) {}
    @Override public int getBufferSize() { return 0; }
    @Override public void flushBuffer() throws IOException {}
    @Override public void resetBuffer() {}
    @Override public boolean isCommitted() { return false; }
    @Override public void reset() {}
    @Override public void setLocale(Locale loc) {}
    @Override public Locale getLocale() { return null; }
}

// Define minimal HttpServletResponse interface
interface HttpServletResponse {
    void setHeader(String name, String value);
    void addHeader(String name, String value);
    void addCookie(Cookie cookie);
    boolean containsHeader(String name);
    String encodeURL(String url);
    String encodeRedirectURL(String url);
    String encodeUrl(String url);
    String encodeRedirectUrl(String url);
    void sendError(int sc, String msg) throws IOException;
    void sendError(int sc) throws IOException;
    void sendRedirect(String location) throws IOException;
    void setDateHeader(String name, long date);
    void addDateHeader(String name, long date);
    void setIntHeader(String name, int value);
    void addIntHeader(String name, int value);
    void setStatus(int sc);
    void setStatus(int sc, String sm);
    int getStatus();
    String getHeader(String name);
    Collection<String> getHeaders(String name);
    Collection<String> getHeaderNames();
    String getCharacterEncoding();
    String getContentType();
    ServletOutputStream getOutputStream() throws IOException;
    PrintWriter getWriter() throws IOException;
    void setCharacterEncoding(String charset);
    void setContentLength(int len);
    void setContentLengthLong(long len);
    void setContentType(String type);
    void setBufferSize(int size);
    int getBufferSize();
    void flushBuffer() throws IOException;
    void resetBuffer();
    boolean isCommitted();
    void reset();
    void setLocale(Locale loc);
    Locale getLocale();
}

// Define minimal Cookie class
class Cookie {
    public Cookie(String name, String value) { }
}

// Define minimal ServletOutputStream class
abstract class ServletOutputStream extends java.io.OutputStream {
}