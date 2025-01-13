import java.lang.String;
public class SecureExample {
    private String sensitiveData;

    public SecureExample(String sensitiveData) {
        this.sensitiveData = sensitiveData;
    }

    public String getPublicData() {
        return "Public Data";
    }

    // Avoid returning sensitive data directly
    public String getSensitiveData() {
        return sensitiveData.substring(0, 4) + "****";
    }

	public static void main(String[] args) {
	}
}