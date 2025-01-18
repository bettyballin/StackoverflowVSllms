import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User();
        String userJson = new ObjectMapper().writeValueAsString(user);
        System.out.println(userJson);
    }
}

class User {
    // Define fields
    private String name;
    private int age;

    // Default constructor
    public User() {
        this.name = "John Doe";
        this.age = 30;
    }

    // Getters and setters (optional if not using reflection)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // You can include setters if needed
}