import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.proxy.ProxyServlet;

public class ReverseProxyServlet extends ProxyServlet {
    @Override
    protected String rewriteTarget(HttpServletRequest request) {
        String originalUrl = request.getRequestURL().toString();
        String rewrittenUrl = originalUrl.replace("someproduct", "foo");
        return rewrittenUrl;
    }

    public static void main(String[] args) {
    }
}