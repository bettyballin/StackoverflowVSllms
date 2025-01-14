import java.lang.String;
import javax.servlet.http.HttpServletRequest;

public class ProxyDetection {

    public static boolean isProxyRequest(HttpServletRequest request) {
        String[] headers = {
            "X-Forwarded-For",
            "Proxy-Connection",
            "Via"
        };

        for (String header : headers) {
            if (request.getHeader(header) != null) {
                return true;
            }
        }
        
        return false;
    }

	public static void main(String[] args) {
	}
}