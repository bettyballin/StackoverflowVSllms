import java.lang.String;
import javax.servlet.http.HttpServletRequest;

public class ProxyDetector {
    public boolean isBehindProxy(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        return xForwardedFor != null && !xForwardedFor.isEmpty();
    }

	public static void main(String[] args) {
	}
}