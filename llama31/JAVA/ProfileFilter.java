import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ProfileFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();
        String[] parts = uri.split("/");
        String username = null;
        if (parts.length > 2) {
            username = parts[2];
        }
        httpRequest.setAttribute("username", username);
        chain.doFilter(request, response);
    }

    public static void main(String[] args) {
    }
}