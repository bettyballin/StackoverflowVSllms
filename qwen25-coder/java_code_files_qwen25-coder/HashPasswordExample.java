import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPasswordExample {

    // Function to convert byte array into a hexadecimal string.
    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Function to hash the password using SHA-256.
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());
        return bytesToHex(hashBytes);
    }

    public static void main(String[] args) {
        HashPasswordExample example = new HashPasswordExample();

        // Placeholder for user inputs
        String user = "brianmay"; // Example username
        String password = "queen"; // Example password

        // Simulate session storage
        java.util.HashMap<String, String> session = new java.util.HashMap<>();

        try {
            // Hash the passwords for comparison
            String hashedBrianMayPassword = example.hashPassword("queen");
            String hashedRogerTaylorPassword = example.hashPassword("queen");
            String hashedFreddieMercuryPassword = example.hashPassword("queen");
            String hashedJohnDeaconPassword = example.hashPassword("queen");

            // Validate the user name and password using hashed values.
            if ((user != null) && (password != null) && (
                (user.equals("brianmay") && example.hashPassword(password).equals(hashedBrianMayPassword)) ||
                (user.equals("rogertaylor") && example.hashPassword(password).equals(hashedRogerTaylorPassword)) ||
                (user.equals("freddiemercury") && example.hashPassword(password).equals(hashedFreddieMercuryPassword)) ||
                (user.equals("johndeacon") && example.hashPassword(password).equals(hashedJohnDeaconPassword))
               )) {
                // Store the user name as a session variable.
                session.put("user", user);
                System.out.println("Login successful. User stored in session.");
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}