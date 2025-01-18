import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUserFilter implements Filter {
    // In your Spring Filter class:
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
    
        // Assuming the logged In user is available as Principal/Authentication object.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth != null ? auth.getName() : "";
    
        request.setAttribute("currentUser", name);
    
        chain.doFilter(request, response);
    }

    public static void main(String[] args) {
    }
}