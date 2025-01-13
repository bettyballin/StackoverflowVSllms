import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.FilterHolder;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Main_547 {
    public static void main(String[] args) {
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new MyServlet()), "/*");
        context.addFilter(new FilterHolder(new MyFilter()), "/*", EnumSet.of(DispatcherType.REQUEST));

        // Register the wrapper
        context.addResponseWrapper(new ServletResponseWrapperInclude());
    }
}

// The following classes are added to make the code compile
class MyServlet extends javax.servlet.http.HttpServlet {}
class MyFilter implements javax.servlet.Filter {
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) {}
    @Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.FilterChain chain) {}
    @Override
    public void destroy() {}
}
class ServletResponseWrapperInclude extends javax.servlet.ServletResponseWrapper {
    public ServletResponseWrapperInclude() {
        super(new javax.servlet.ServletResponse() {
            @Override
            public void setCharacterEncoding(String charset) {}
            @Override
            public String getCharacterEncoding() { return null; }
            @Override
            public javax.servlet.ServletOutputStream getOutputStream() throws java.io.IOException { return null; }
            @Override
            public java.io.PrintWriter getWriter() throws java.io.IOException { return null; }
            @Override
            public void setContentLength(int len) {}
            @Override
            public void setContentLengthLong(long len) {}
            @Override
            public void setContentType(String type) {}
            @Override
            public void setBufferSize(int size) {}
            @Override
            public int getBufferSize() { return 0; }
            @Override
            public void flushBuffer() throws java.io.IOException {}
            @Override
            public void resetBuffer() {}
            @Override
            public boolean isCommitted() { return false; }
            @Override
            public void reset() {}
            @Override
            public void setLocale(java.util.Locale loc) {}
            @Override
            public java.util.Locale getLocale() { return null; }
        });
    }
}