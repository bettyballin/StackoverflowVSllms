import java.util.HashMap;
import java.util.Map;

// DTO for transferring User data
public class UserDTO {
    private Long id;
    private String name;
    // getters and setters
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

// Repository interface
public interface UserRepository {
    UserDTO findById(Long id);
    void save(UserDTO user);
    // other CRUD methods
}

// In-memory implementation (for testing purposes)
public class MemoryUserRepository implements UserRepository {
    private final Map<Long, UserDTO> users = new HashMap<>();

    @Override
    public UserDTO findById(Long id) {
        return users.get(id);
    }

    @Override
    public void save(UserDTO user) {
        if (user.getId() == null) {
            user.setId(users.size() + 1L);
        }
        users.put(user.getId(), user);
    }
}

// Example usage in a service layer
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void addUser(UserDTO user) {
        userRepository.save(user);
    }

    public static void main(String[] args) {
    }
}