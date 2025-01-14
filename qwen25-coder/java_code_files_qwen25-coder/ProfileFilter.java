package com.example;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ProfileFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if necessary
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String pathInfo = httpRequest.getPathInfo();

        String usernameToDisplay = null;

        // Check if the URL pattern is correct and extract the name part
        if (pathInfo != null && !"/".equals(pathInfo)) {
            usernameToDisplay = pathInfo.substring(1);  // Remove leading '/'
        }

        // Set an attribute for use in JSP
        request.setAttribute("profileName", usernameToDisplay);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if necessary
    }

    public static void main(String[] args) {
    }
}