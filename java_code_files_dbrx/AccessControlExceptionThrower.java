import java.lang.String;
import java.security.AccessControlException;
public class AccessControlExceptionThrower {
	static {
		throw new AccessControlException("Not authorized to perform this operation", "customCode1");
	}
	public static void main(String[] args) {
	}
}