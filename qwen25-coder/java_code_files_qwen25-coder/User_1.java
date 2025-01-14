public class User_1 {
    private String email;

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        this.email = email;
    }

    // Additional getters and setters...

    public static void main(String[] args) {
    }
}