public class UserService_3 {
    private final UserRepository userRepository;

    public UserService_3(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        // Validation in Service Layer
        if (user.getName() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("Name and email are required.");
        }
        userRepository.save(user);
    }
}

interface UserRepository {
    void save(User user);

    public static void main(String[] args) {
        // Main method content (if any)
    }
}

class User {
    private String name;
    private String email;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }
}