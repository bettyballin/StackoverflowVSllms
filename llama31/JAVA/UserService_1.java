// User.java
public class User {
    private Long id;
    private String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// UserRepository.java
public interface UserRepository {
    User findById(Long id);
}

// UserRepositoryImpl.java
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findById(Long id) {
        // Simple implementation for demonstration purposes.
        // In a real application, this would typically involve database access.
        return new User(id, "Demo User");
    }

    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = userRepository.findById(1L);
        System.out.println("User ID: " + user.getId());
        System.out.println("User Name: " + user.getName());
    }
}

// UserService.java
public class UserService_1 {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserService(userRepository);
        User user = userService.getUser(1L);
        System.out.println("User ID from UserService: " + user.getId());
        System.out.println("User Name from UserService: " + user.getName());
    }
}