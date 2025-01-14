// Java SDK example

public class PayPalExample {
    public static void main(String[] args) {
        PayPalEnvironment environment = new SandboxEnvironment("YOUR_CLIENT_ID", "YOUR_SECRET");
    }
}

class PayPalEnvironment {
    protected String clientId;
    protected String clientSecret;

    public PayPalEnvironment(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }
}

class SandboxEnvironment extends PayPalEnvironment {
    public SandboxEnvironment(String clientId, String clientSecret) {
        super(clientId, clientSecret);
    }
}