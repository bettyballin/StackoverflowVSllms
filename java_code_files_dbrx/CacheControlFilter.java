import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CacheControlFilter implements Filter {

    private static final String CACHE_CONTROL = "Cache-Control";
    private static final long MILLISECONDS_PER_DAY = 1000L * 60 * 60 * 24; // milliseconds x seconds x minutes x hours x days.
    private static final long DEFAULT_MAX_AGE = 1L;
    private long maxAgeInDays;
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

        if (filterConfig != null) {
            try {
                String age = filterConfig.getInitParameter("max-age");

                // If any numeric input, convert it to long. Otherwise, use default values defined above.
                maxAgeInDays = age == null ? DEFAULT_MAX_AGE : Long.parseLong(age);
            } catch (NumberFormatException e) {
                throw new ServletException("Cannot parse cache control param", e);
            }
        } else { // no initialization, use default values for max-age
            this.maxAgeInDays = DEFAULT_MAX_AGE;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Prepare headers for images with far future expiration dates on them.
        response.addHeader(CACHE_CONTROL, "public");
        // The client should make a conditional GET request after this number of seconds since this request was made or the cache entry is considered 'stale'.
        response.setDateHeader("Expires", System.currentTimeMillis() + (maxAgeInDays * MILLISECONDS_PER_DAY));
        // Forcing a 304 return from the browser can be accomplished with:
        if ("partial".equals(filterConfig.getInitParameter("cache-control"))) {
            response.setHeader("ETag", Integer.toString(servletRequest.hashCode()));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // Clean up any resources here if needed
    }

    public static void main(String[] args) {
        // Main method implementation if needed
    }
}