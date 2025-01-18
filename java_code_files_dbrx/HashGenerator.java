import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
    // server code 
    String data = "example message"; 
    int clientCounter = 23; // sent by client 
    int myCounter = 22; // this counter
    String secretKey = "my_secret_key_123"; 

    public static void main(String[] args) throws NoSuchAlgorithmException {
        HashGenerator hg = new HashGenerator();

        // Combine the data, counters and a secret key to create a hash. 
        String hashDataClient = hg.myCounter + "_" + hg.clientCounter + "_" + hg.secretKey; 

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(hashDataClient.getBytes()); 
        byte[] bytes = md.digest(); // checksum of the server copy.

        // Send this hash to client as a response.
        Client client = new Client();
        client.sendMessage(bytes);
    }
}

class Client {
    public void sendMessage(byte[] bytes) {
        // send message implementation here
        // For now, we'll just print out the bytes in hex for demonstration
        System.out.print("Sending message: ");
        for (byte b : bytes) {
            System.out.printf("%02x", b);
        }
        System.out.println();
    }
}