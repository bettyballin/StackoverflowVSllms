import java.lang.String;

public class CryptTest {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.err.println("Usage: cryptTest (encrypt|decrypt) key iv algorithm mode");
            System.err.println("Takes input from STDIN. Output goes to STDOUT.");
        } else {
            String operation = args[0];
            String key = args[1];
            String iv = args[2];
            String algorithm = args[3];
            String mode = args[4];
            try {
                BlockCrypt blockCrypt = new BlockCrypt(key, iv, algorithm, mode);
                if (operation.equalsIgnoreCase("encrypt")) {
                    blockCrypt.encrypt(System.in, System.out);
                } else if (operation.equalsIgnoreCase("decrypt")) {
                    blockCrypt.decrypt(System.in, System.out);
                } else {
                    System.err.println("Invalid operation. Use (encrypt|decrypt).");
                }
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }
}

class BlockCrypt {
    // You need to implement the BlockCrypt class with encrypt and decrypt methods
    // You also need to handle the necessary exceptions
    public BlockCrypt(String key, String iv, String algorithm, String mode) {
        // implementation
    }

    public void encrypt(java.io.InputStream in, java.io.OutputStream out) {
        // implementation
    }

    public void decrypt(java.io.InputStream in, java.io.OutputStream out) {
        // implementation
    }
}