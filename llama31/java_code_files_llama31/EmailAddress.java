/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddress {
    private final String address;

    public EmailAddress(String string) {
        if (!EmailAddress.isValidEmail(string)) {
            throw new InvalidEmailException("Invalid email address");
        }
        this.address = string;
    }

    public String getAddress() {
        return this.address;
    }

    public static boolean isValidEmail(String string) {
        String string2 = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(string2);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static void main(String[] stringArray) {
        try {
            EmailAddress emailAddress = new EmailAddress("example@example.com");
            System.out.println(emailAddress.getAddress());
        }
        catch (InvalidEmailException invalidEmailException) {
            System.out.println(invalidEmailException.getMessage());
        }
    }

    public static class InvalidEmailException
    extends RuntimeException {
        public InvalidEmailException(String string) {
            super(string);
        }
    }
}
