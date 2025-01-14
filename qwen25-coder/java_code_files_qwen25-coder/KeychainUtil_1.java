import java.lang.String;
public class KeychainUtil_1 {
    public static void addToKeychain(String account, String service, String password) throws Exception {
        Process process = new ProcessBuilder(
            "security", "add-generic-password", "-a", account, "-s", service, "-w", password, "-U"
        ).start();
        
        int exitCode = process.waitFor();
        if (exitCode != 0) throw new RuntimeException("Failed to add credentials to keychain.");
    }

	public static void main(String[] args) {
	}
}