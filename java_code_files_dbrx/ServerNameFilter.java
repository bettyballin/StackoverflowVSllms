package your.package.containing;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServerNameFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if necessary
    }

    @Override
    public void destroy() {
        // Cleanup code, if necessary
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpReq) {
            @Override
            public String getServerName() {
                return "your-servername";
            }

            @Override
            public String getLocalAddr() {
                return "your-local-address";
            }
        };
        chain.doFilter(wrapper, res);
    }
}

/* Add this to your web application's XML file */
/*
<filter>
  <filter-name>ServerNameFilter</filter-name>
  <filter-class>your.package.containing.ServerNameFilter</filter-class>
</filter>
*/