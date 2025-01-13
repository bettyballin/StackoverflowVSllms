import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code here, if any
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession(false);
        
        if (session == null) {
            session = req.getSession(true);
        }
        
        // if there is no userBean, then they have not gone through
        // the login, so kick them to the login page
        if (null == session.getAttribute("username")) {
            ((HttpServletResponse)servletResponse).sendRedirect("../Login.jsp");
            System.out.println("Redirected - No session");
        } else {
            // otherwise, let them go to the page/resource they want
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("Gone through Filter");
        }
    }

    @Override
    public void destroy() {
        // Cleanup code here, if any
    }

    public static void main(String[] args) {
        // Since this is a servlet filter, it's not typically executed from a main method.
        // Instead, it's configured in the web application's deployment descriptor (web.xml)
        // or through annotations, and the servlet container executes it.
    }
}