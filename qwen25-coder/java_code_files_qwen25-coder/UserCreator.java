public class UserCreator {
    public static void main(String[] args) {
        try {
            // Initialize JForum context and repositories if needed
            User user = new User();
            user.setUsername("newuser");
            user.setEmail("newuser@example.com");
            user.setPassword(JForumExecutionContext.getMessageDigest().digest("newusersecurepassword"));

            UserRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Simulated User class
class User {
    private String username;
    private String email;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }
}

// Simulated UserRepository class
class UserRepository {
    public static void save(User user) {
        // Simulate saving the user
        System.out.println("User saved: " + user.getUsername());
    }
}

// Simulated JForumExecutionContext class
class JForumExecutionContext {
    public static MessageDigest getMessageDigest() {
        return new MessageDigest();
    }
}

// Simulated MessageDigest class
class MessageDigest {
    public String digest(String input) {
        // Simulate message digest (simple hash code for demonstration)
        return Integer.toHexString(input.hashCode());
    }
}