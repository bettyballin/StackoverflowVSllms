import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomStaticResourceFilter implements Filter {
    private static final String RESOURCE_PATH = "/META-INF/resources/";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialize the filter
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestedResource = httpRequest.getRequestURI();
        if (requestedResource.startsWith(RESOURCE_PATH)) {
            URL resourceUrl = getClass().getClassLoader().getResource(requestedResource);
            if (resourceUrl != null) {
                // Include the JavaScript file in the JSP page
                httpResponse.setContentType("application/javascript");
                httpResponse.getWriter().write(readResource(resourceUrl));
                return;
            }
        }

        chain.doFilter(request, response);
    }

    private String readResource(URL resourceUrl) throws IOException {
        // Read the contents of the JavaScript file
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceUrl.openStream()));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }

    public static void main(String[] args) {
        // This is a servlet filter, it's not meant to be run from the command line
    }
}