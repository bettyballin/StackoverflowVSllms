import java.lang.String;
public class SessionManager_3 {
    public void validateSession(String currentIP, String storedIP) throws SecurityException {
        if (!currentIP.equals(storedIP)) {
            throw new SecurityException("IP mismatch detected. Please log in again.");
        }
    }

	public static void main(String[] args) {
	}
}