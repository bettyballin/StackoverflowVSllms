import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ContentDispositionFilter", urlPatterns = { "/*" }, initParams = {
        @WebInitParam(name = "content-disposition-header-filename", value = "default_file.zip") })
public class ContentDispositionFilter implements Filter {
    private String defaultFilename;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (((HttpServletResponse) response).getHeader("Content-Type").startsWith("application/zip")) {
            ((HttpServletResponse) response).setHeader("Content-Disposition",
                    "attachment; filename=\"" + this.defaultFilename + "\"");
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        this.defaultFilename = config.getInitParameter("content-disposition-header-filename");
    }

    public static void main(String[] args) {
    }
}