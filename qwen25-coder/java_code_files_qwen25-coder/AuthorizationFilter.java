import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;

public class AuthorizationFilter implements Filter {
    private String roles;
    private String onErrorPage;

    public void init(FilterConfig filterConfig) throws ServletException {
        roles = filterConfig.getInitParameter("roles");
        onErrorPage = filterConfig.getInitParameter("onError");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the user is authorized
        Principal principal = httpRequest.getUserPrincipal();
        boolean isAuthorized = false;
        if (principal != null && principal instanceof MyCustomPrincipal) {
            MyCustomPrincipal myPrincipal = (MyCustomPrincipal) principal;
            String role = myPrincipal.getRole();
            isAuthorized = roles.contains(role);
        }

        if (!isAuthorized) {
            // Store the requested URL
            String requestURL = httpRequest.getRequestURL().toString();
            String queryString = httpRequest.getQueryString();
            if (queryString != null) {
                requestURL += "?" + queryString;
            }
            HttpSession session = httpRequest.getSession();
            session.setAttribute("auth_redirect_url", requestURL);

            // Redirect to login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + onErrorPage);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}
}

// Custom Principal implementation
class MyCustomPrincipal implements Principal {
    private String name;
    private String role;

    public MyCustomPrincipal(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

// In your LoginServlet or wherever you handle authentication:
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assume authenticateUser returns true if authentication succeeds
        boolean authenticated = authenticateUser(request);

        if (authenticated) {
            HttpSession session = request.getSession();
            String redirectURL = (String) session.getAttribute("auth_redirect_url");
            if (redirectURL != null) {
                // Redirect to the stored URL
                response.sendRedirect(redirectURL);
                // Remove the attribute after using it
                session.removeAttribute("auth_redirect_url");
            } else {
                // If no redirect URL is found, go to default page (Dashboard)
                response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
            }
        } else {
            request.setAttribute("error", "Invalid credentials!");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

    private boolean authenticateUser(HttpServletRequest request) {
        // Your authentication logic here
        return true; // Just an example, replace with real logic.
    }

    public static void main(String[] args) {
    }
}