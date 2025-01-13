import java.lang.String;

// Entity class (e.g., User)
public class User_48_48 {
    private Long id;
    private String name;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

// DTO class (e.g., UserDTO)
public class User_48_48DTO {
    private Long id;
    private String name;

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

// Service class (e.g., UserService)
public class User_48_48Service {
    private UserRepository userRepository;

    public User_48DTO getUser(Long id) {
        User_48 user = userRepository.findById(id).orElseThrow();
        User_48DTO userDTO = new User_48DTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }

    public static void main(String[] args) {
        // Create an instance of the service
        User_48Service service = new User_48Service();

        // Call the getUser method
        User_48DTO userDTO = service.getUser(1L);

        // Print the result
        System.out.println(userDTO.getId());
        System.out.println(userDTO.getName());
    }
}

// Repository interface (e.g., UserRepository)
interface UserRepository {
    java.util.Optional<User_48> findById(Long id);
}

// Repository implementation (e.g., UserRepositoryImpl)
class UserRepositoryImpl implements UserRepository {
    @Override
    public java.util.Optional<User_48> findById(Long id) {
        // Simulate data access
        User_48 user = new User_48();
        user.setId(id);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        return java.util.Optional.of(user);
    }
}