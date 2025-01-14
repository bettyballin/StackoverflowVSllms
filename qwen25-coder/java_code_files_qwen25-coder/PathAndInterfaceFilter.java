import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PathAndInterfaceFilter implements Filter {

    private String blockedPathPrefix = "/a/b/";
    private String allowedIpAddress = "127.0.0.1"; // Change this to the IP address of your application

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI();
        String remoteAddr = httpRequest.getRemoteAddr();

        if (path.startsWith(blockedPathPrefix) && !remoteAddr.equals(allowedIpAddress)) {
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Access denied.");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }

	public static void main(String[] args) {
	}
}