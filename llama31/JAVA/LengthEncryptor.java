import java.lang.String;

public class LengthEncryptor {
    public static int calculateEncryptedLength(int inputLength) {
        return ((inputLength + 7) / 8) * 8;
    }

    public static void main(String[] args) {
    }
}