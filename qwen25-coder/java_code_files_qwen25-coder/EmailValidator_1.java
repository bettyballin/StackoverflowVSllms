import java.lang.String;
import java.util.regex.*;
import java.io.*;
import java.nio.file.*;

public class EmailValidator_1 {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("emails.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processLine(String line) {
        String[] parts = line.split(":");
        if (parts.length < 2) return;

        for (String email : parts[1].split(";")) {
            // Remove surrounding quotes and spaces
            email = email.trim().replaceAll("^\"|\"$", "").trim();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email: " + email);
            }
        }
    }

    private static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}