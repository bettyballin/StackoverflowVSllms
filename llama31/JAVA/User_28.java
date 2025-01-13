import java.util.List;

// Simplified Entity class
public class User_28 {
    private Long id;
    private String name;
    private String email;
    
    // Constructor, getters, and setters
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}

// Simplified DAO class
public class User_28Dao {
    private List<User> users = new java.util.ArrayList<>();
    
    public List<User> getAllUsers() {
        return users;
    }
    
    public User getUserById(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    
    public void saveUser(User user) {
        users.add(user);
    }
    
    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
    
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User(1L, "John Doe", "john@example.com");
        userDao.saveUser(user);
        
        System.out.println("Users: " + userDao.getAllUsers());
        System.out.println("User by ID 1: " + userDao.getUserById(1L));
        userDao.deleteUser(1L);
        System.out.println("After deletion: " + userDao.getAllUsers());
    }
}