public class RegexPatternConstants {
    // Example regex for username: allowing letters, numbers, underscore, hyphen, and dot
    String usernamePattern = "^[A-Za-z0-9_\\-\\.]{5,20}$";
    
    // Example regex for password: allowing all printable characters except whitespace
    String passwordPattern = "^(?=.*[!@#$%^&*()\\-+={}\\[\\]|\\\\:;'\"<>,.?/`~])[A-Za-z0-9!@#$%^&*()\\-+=\\{}\\[\\]|\\\\:;'\",.<>?/~]{8,50}$";
    
    public static void main(String[] args) {
    }
}