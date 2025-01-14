import java.lang.String;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.File;
import java.io.IOException;

@WebFilter("/*")
public class MaintenanceFilter implements Filter {
    private static final String MAINTENANCE_FLAG_PATH = "/path/to/maintenance.flag";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        File maintenanceFlag = new File(MAINTENANCE_FLAG_PATH);
        if (maintenanceFlag.exists()) {
            request.getRequestDispatcher("/maintenance.html").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

	public static void main(String[] args) {
	}
}