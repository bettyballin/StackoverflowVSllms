import java.lang.String;
public class SecurePassword {
    public final class SecurePasswordHelper {
        private SecurePasswordHelper() {}
    
        public static String toUnsecureString(char[] secureArray) {
            return new String(secureArray);
        }
    }
	public static void main(String[] args) {
	}
}