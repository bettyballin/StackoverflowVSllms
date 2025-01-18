import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;

import com.opensymphony.module.sitemesh.filter.PageParseFilter;

import java.io.IOException;

public class DecorateAllFilter implements Filter {
    FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
        final javax.servlet.FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        Object hasDecorated = req.getAttribute("Sitemesh_hasDecorated"); // sitemesh sets this attrib when decoration applied.
        if (null == hasDecorated && "FORWARD".equals(request.getDispatcherType().name())) {  // this is a forward, apply site-mesh decoration!
            new PageParseFilter().doFilter(req, res, chain);  // Apply SiteMesh decorations now!
        } else {    // it wasn't a forward or has already been decorated.
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        // Any necessary cleanup code here
    }
}