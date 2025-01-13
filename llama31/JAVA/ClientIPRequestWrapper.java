import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ClientIPRequestWrapper extends HttpServletRequestWrapper {
    public ClientIPRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getRemoteAddr() {
        String ipAddress = super.getHeader("X-Forwarded-For");
        if (ipAddress != null) {
            return ipAddress;
        }
        return super.getRemoteAddr();
    }

    public static void main(String[] args) {
    }
}