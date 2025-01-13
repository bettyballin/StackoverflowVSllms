import java.io.File;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MaintenanceFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) {
    // No-op
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String contextPath = httpRequest.getContextPath();
    File maintenanceFlag = new File(contextPath + "/maintenance.flag");
    if (maintenanceFlag.exists()) {
      httpRequest.getRequestDispatcher("/maintenance.html").forward(request, response);
    } else {
      chain.doFilter(request, response);
    }
  }

  @Override
  public void destroy() {
    // No-op
  }

  public static void main(String[] args) {
  }
}