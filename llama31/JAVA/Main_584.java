import java.util.Base64;

public class Main_584 {
    public static void main(String[] args) {
        byte[] encryptedBytes = new byte[33]; // assume this is your encrypted byte array

        String encodedString = Base64.getEncoder().encodeToString(encryptedBytes);
        char[] encodedChars = encodedString.toCharArray();

        System.out.println("Byte array length: " + encryptedBytes.length); // 33
        System.out.println("Char array length: " + encodedChars.length); // 44
    }
}