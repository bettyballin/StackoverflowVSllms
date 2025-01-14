import java.lang.String;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

// Example Servlet Filter to log file downloads
public class DownloadFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        String filePath = httpRequest.getRequestURI();
        
        // Check if the requested file is foo.zip
        if ("/foo.zip".equals(filePath)) {
            logDownload(httpRequest.getRemoteAddr());
        }
        
        // Continue with the rest of the filter chain
        chain.doFilter(request, response);
    }

    private void logDownload(String ipAddress) {
        // Implement your logging logic here
        // For example, write to a file or store in a database
        System.out.println("File downloaded from IP: " + ipAddress);
    }

    @Override
    public void destroy() {
        // Cleanup code if necessary
    }

	public static void main(String[] args) {
	}
}