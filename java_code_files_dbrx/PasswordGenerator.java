import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    public String getRandomPassword(int length) {
        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lower = "abcdefghijklmnopqrstuvwxyz";
        final String digits = "0123456789";
        final String specialChars = "@#$%&*!?";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length / 2; ++i) {
            int rndCharAt = random.nextInt(upper.length());
            char rndChar = upper.charAt(rndCharAt);
            sb.append(rndChar);
        }

        for (int i = 0; i < length / 4; ++i) {
            int index = random.nextInt(lower.length());
            sb.append(lower.charAt(index));
        }

        for (int i = 0; i < length / 6; ++i) {
            int idx = random.nextInt(digits.length());
            sb.append(digits.charAt(idx));
        }

        for (int i = 0; i < length / 7; ++i) {
            int idd = random.nextInt(specialChars.length());
            char speChar = specialChars.charAt(idd);
            sb.append(speChar);
        }

        // Shuffle the characters in the StringBuilder
        String password = sb.toString();
        List<Character> passwordChars = new ArrayList<>();
        for (char c : password.toCharArray()) {
            passwordChars.add(c);
        }
        Collections.shuffle(passwordChars, random);
        StringBuilder shuffledPassword = new StringBuilder();
        for (char c : passwordChars) {
            shuffledPassword.append(c);
        }
        return shuffledPassword.toString();
    }

    public static void main(String[] args) {
        PasswordGenerator pg = new PasswordGenerator();
        String password = pg.getRandomPassword(16);
        System.out.println("Random Password: " + password);
    }
}