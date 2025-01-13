import java.lang.String;

// Assuming User and UserNotFoundException are custom classes, 
// you need to import or define them
class User {}
class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

// Assuming userRepository is an object of a class that has a findById method, 
// you need to define or import that class
class UserRepository {
    public User findById(Long id) {
        // implementation of the findById method
        return null;
    }
}

public class UserServiceImpl_2_2 {
    private UserRepository userRepository = new UserRepository();

    public User getUserById(Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found with ID " + id);
        }
        return user;
    }

    public static void main(String[] args) {
        // You can test the getUserById method here
        UserServiceImpl_2 userService = new UserServiceImpl_2();
        try {
            User user = userService.getUserById(1L);
            System.out.println(user);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}