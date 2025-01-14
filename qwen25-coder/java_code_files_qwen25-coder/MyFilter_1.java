import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code if necessary
    }

    @Override
    public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain chain)
            throws IOException, ServletException {
        String fileName = "fileName.xls";
        HttpServletRequest httpRequest = (HttpServletRequest) pRequest;
        String requestURI = httpRequest.getRequestURI();
        System.out.println("Requested URI: " + requestURI); // Logging for debug

        if (requestURI != null && !requestURI.trim().isEmpty()) {
            String uri[] = requestURI.split("/");
            fileName = uri[uri.length - 1];
            System.out.println("Parsed file name: " + fileName); // Logging for debug
        }

        HttpServletResponse httpResponse = (HttpServletResponse) pResponse;
        httpResponse.setContentType("application/vnd.ms-excel");
        httpResponse.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");

        // Pass the request and response along the filter chain
        chain.doFilter(pRequest, pResponse);
    }

    @Override
    public void destroy() {
        // Cleanup code if necessary
    }
}