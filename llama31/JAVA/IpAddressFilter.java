import java.lang.String;
import javax.servlet.http.HttpServletRequest;

public class IpAddressFilter {
    private static final String INTERNAL_IP_REGEX = "^10\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";

    public boolean isInternalRequest(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        return ipAddress.matches(INTERNAL_IP_REGEX);
    }

	public static void main(String[] args) {
	}
}