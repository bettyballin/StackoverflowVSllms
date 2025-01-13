import java.util.Arrays;

public class SecureDataHandler {
    char[] sensitiveData = "secret".toCharArray();

    // When done, clear the char array
    {
        Arrays.fill(sensitiveData, '0');
    }

    public static void main(String[] args) {
        new SecureDataHandler();
    }
}