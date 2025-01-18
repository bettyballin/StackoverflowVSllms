import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaintenanceFilter implements Filter {
    private boolean isMaintenanceMode = false;

    public void init(FilterConfig config) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (isMaintenanceMode && !req.getRequestURI().contains("maintenance")) {
            res.sendRedirect(req.getContextPath() + "/maintenance");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}

    public static void main(String[] args) {
    }
}