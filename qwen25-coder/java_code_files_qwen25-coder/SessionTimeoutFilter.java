import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionTimeoutFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        // Assuming the header name is 'Custom-Session-Time-Out'
        String timeOutHeader = httpRequest.getHeader("Custom-Session-Time-Out");

        if (timeOutHeader != null && !timeOutHeader.isEmpty()) {
            int timeoutValue = Integer.parseInt(timeOutHeader);
            if (session == null) {
                session = httpRequest.getSession(true);
            }
            session.setMaxInactiveInterval(timeoutValue);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

    public static void main(String[] args) {
    }
}