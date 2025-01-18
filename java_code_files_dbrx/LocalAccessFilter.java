import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class LocalAccessFilter implements Filter {
    private static final String[] LOCAL_INTERFACES = {"127", "::1"}; // Add more as per your need

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code can go here if needed
    }

    @Override
    public void destroy() {
        // Any cleanup code can go here
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        boolean isLocalAccess = false;
        String clientIP = req.getRemoteAddr();
        for (String local : LOCAL_INTERFACES) {
            if (clientIP.startsWith(local)) {
                isLocalAccess = true;
                break;
            }
        }
        if (!isLocalAccess && ((HttpServletRequest) req).getRequestURI().startsWith("/a/b")) {
            throw new ServletException("Unauthorized Access");
        } else {
            chain.doFilter(req, resp);
        }
    }
}