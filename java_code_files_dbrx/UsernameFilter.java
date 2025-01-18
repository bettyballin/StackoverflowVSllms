import java.lang.String;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.FilterChain;
import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;

public class UsernameFilter {
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String userName = ((HttpServletRequest) request).getRemoteUser();
    }
    public static void main(String[] args) {
    }
}