public class UsernameValidator {
    public boolean isValidUsername(String username) {
        return username != null && username.matches("[a-zA-Z0-9_]{1,20}");
    }

    public static void main(String[] args) {
    }
}