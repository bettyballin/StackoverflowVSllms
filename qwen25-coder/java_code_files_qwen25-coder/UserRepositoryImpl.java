import java.util.List;
import java.util.ArrayList;

// Example using Repository Pattern

public interface UserRepository {
    User findByIdWithOrders(int userId);
}

class UserRepositoryImpl implements UserRepository {
    private final UserDataMapper userDataMapper;
    private final OrderDataMapper orderDataMapper;

    public UserRepositoryImpl(UserDataMapper userDataMapper, OrderDataMapper orderDataMapper) {
        this.userDataMapper = userDataMapper;
        this.orderDataMapper = orderDataMapper;
    }

    @Override
    public User findByIdWithOrders(int userId) {
        User user = userDataMapper.findById(userId);
        List<Order> orders = orderDataMapper.findByUserId(userId);
        user.setOrders(orders);
        return user;
    }
}

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserWithDetails(int userId) {
        return userRepository.findByIdWithOrders(userId);
    }

    public static void main(String[] args) {
        // Create instances of data mappers
        UserDataMapper userDataMapper = new UserDataMapper();
        OrderDataMapper orderDataMapper = new OrderDataMapper();

        // Create repository implementation
        UserRepository userRepository = new UserRepositoryImpl(userDataMapper, orderDataMapper);

        // Create the service
        UserService userService = new UserService(userRepository);

        // Fetch user with details
        User user = userService.getUserWithDetails(1);

        System.out.println("User obtained with details: " + user);
    }
}

// Additional classes required for compilation

class User {
    private List<Order> orders;

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" + "orders=" + orders + '}';
    }
}

class UserDataMapper {
    public User findById(int userId) {
        // Simulate fetching a user from a data source
        return new User();
    }
}

class OrderDataMapper {
    public List<Order> findByUserId(int userId) {
        // Simulate fetching orders for a user from a data source
        return new ArrayList<>();
    }
}

class Order {
    // Placeholder for Order properties and methods
}