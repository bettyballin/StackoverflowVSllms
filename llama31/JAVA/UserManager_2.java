import java.lang.String;

class User {
    private String name;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class UserManager_2_2 {
    public static void main(String[] args) {
        // Using a Java API to create a user
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
    }
}