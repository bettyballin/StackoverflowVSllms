import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;

public class MyFilter_3_3 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            // Your code here...
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // Log the error
            Logger.getLogger(MyFilter_3.class.getName()).log(Level.SEVERE, t.getMessage(), t);
            // Let the container handle the error
            throw new ServletException(t);
        }
    }

    public static void main(String[] args) {
        System.out.println("This is a Servlet Filter and is not meant to be run from the command line.");
        System.out.println("It should be deployed in a Servlet container like Apache Tomcat.");
    }
}