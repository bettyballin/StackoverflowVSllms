import java.lang.String;
import java.security.SecureRandom;
import java.util.HashSet;

public class TinyUrlUidGenerator {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int UID_LENGTH = 6;

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        int clashes = 0;
        for (int n = 0; n < 1000000; n++) {
            String uid = generateUid();
            if (!set.add(uid)) {
                clashes++;
                System.out.println("clash: (" + n + ")" + uid);
            }
        }

        System.out.println("Clashes: " + clashes);
    }

    private static String generateUid() {
        StringBuilder builder = new StringBuilder(UID_LENGTH);
        for (int i = 0; i < UID_LENGTH; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            builder.append(CHARACTERS.charAt(index));
        }
        return builder.toString();
    }
}