import java.lang.String;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URLMaskingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String url = httpRequest.getRequestURI();
        String query = httpRequest.getQueryString();

        if (query != null && query.contains("id") && query.contains("name")) {
            String id = getParameterValue(query, "id");
            String name = getParameterValue(query, "name");

            String newUrl = "/product-" + name.replace("_", "-");
            httpResponse.sendRedirect(newUrl);

            // You can also use forward if you want to hide the original URL
            // RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(newUrl);
            // dispatcher.forward(httpRequest, httpResponse);
        } else {
            chain.doFilter(request, response);
        }
    }

    private String getParameterValue(String query, String parameterName) {
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            if (pair.startsWith(parameterName + "=")) {
                return pair.substring(pair.indexOf("=") + 1);
            }
        }
        return null;
    }

    @Override
    public void destroy() {
    }

	public static void main(String[] args) {
	}
}