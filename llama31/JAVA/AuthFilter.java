import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the request is for static content
        if (httpRequest.getRequestURI().startsWith("/static/")) {
            // Authenticate the request
            String authHeader = httpRequest.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Basic ")) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.setHeader("WWW-Authenticate", "Basic realm=\"My Realm\"");
                return;
            }

            // Validate the credentials
            String[] credentials = authHeader.substring(6).split(":");
            String username = credentials[0];
            String password = credentials[1];

            // Replace with your own authentication logic
            if (!username.equals("admin") || !password.equals("password")) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        // If authenticated, proceed with the request
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

	public static void main(String[] args) {
	}
}