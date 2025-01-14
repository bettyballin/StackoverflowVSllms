// Example Domain Model
public class User_39 {
    private String id;
    private String name;
    private String email;
    // getters, setters

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    // setters
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

// Corresponding DTO
public class User_39DTO {
    private String id;
    private String name;

    public User_39DTO(User_39 user) {
        this.id = user.getId();
        this.name = user.getName();
    }
    // getters, no setters (immutable structure)

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Usage in service layer or controller
public class Main {
    // Simulated user repository
    static class UserRepository {
        public User_39 findById(String id) {
            // Simulate fetching user from database
            User_39 user = new User_39();
            user.setId(id);
            user.setName("John Doe");
            user.setEmail("johndoe@example.com");
            return user;
        }
    }

    public User_39DTO getUserById(String id) {
        UserRepository userRepository = new UserRepository();
        User_39 user = userRepository.findById(id);  // Assume userRepository fetches from database
        return new User_39DTO(user);
    }

    public static void main(String[] args) {
        Main main = new Main();
        User_39DTO userDTO = main.getUserById("1");
        System.out.println("User ID: " + userDTO.getId());
        System.out.println("User Name: " + userDTO.getName());
    }
}