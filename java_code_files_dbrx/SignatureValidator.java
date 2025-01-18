public class SignatureValidator {
    public static void main(String[] args) {
        try {
            String signingKey = ""; // Some secure unique key which is used to sign connection from our tool only
            String clientSignature = "ourtool_signature"; // Get signature of requesting application, here it's 'ourtool'
            String dataToSign = "data"; // Data that needs to be signed
            Client client = new Client(signingKey);
            if (!client.sign(dataToSign).equals(clientSignature)) { // Check if the incoming signature equals the signature created by our tool's signing function
                throw new RuntimeException("Access Denied");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}

class Client {
    private String key;

    public Client(String key) {
        this.key = key;
    }

    public String sign(String dataToSign) {
        // Implement the signing logic using key and dataToSign
        // For demonstration purposes, return the expected signature
        return "ourtool_signature";
    }
}