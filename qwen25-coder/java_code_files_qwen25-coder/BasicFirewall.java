import java.lang.String;
// Example of basic firewall configuration in Java (pseudo-code for demonstration)
public class BasicFirewall {
    public void configureRules() {
        allowInboundSSH();
        denyAllOtherInbounds();
        logAttempts();
    }

    private void allowInboundSSH() {
        // Allow incoming SSH traffic
        System.out.println("Allowing inbound SSH on port 22");
    }

    private void denyAllOtherInbounds() {
        // Deny all other incoming traffic
        System.out.println("Denying all other inbound traffic");
    }

    private void logAttempts() {
        // Log all access attempts for auditing
        System.out.println("Logging all access attempts");
    }

	public static void main(String[] args) {
	}
}