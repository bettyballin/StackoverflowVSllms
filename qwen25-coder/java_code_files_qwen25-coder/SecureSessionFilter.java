import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecureSessionFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) 
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        // Ensure session is created
        HttpSession session = req.getSession();

        // Set SameSite and Secure cookie attributes
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setPath("/");
        cookie.setSecure(true);  // Only send the cookie over HTTPS
        cookie.setHttpOnly(true);
        cookie.setAttribute("SameSite", "Strict");  // Prevent sending the cookie along with cross-origin requests

        res.addCookie(cookie);

        // Check if there is no userBean, then they have not gone through the login, so kick them to the login page
        if (null == session.getAttribute("username")) {
            res.sendRedirect("../Login.jsp");
            System.out.println("Redirected - No session");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("Gone through Filter");
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if needed
    }

    public void destroy() {
        // Cleanup code if needed
    }

    public static void main(String[] args) {
    }
}