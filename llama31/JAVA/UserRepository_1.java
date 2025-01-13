// Define the Encryptor interface
interface Encryptor {
    String encrypt(String data);
    String decrypt(String data);
}

// Define the User class
class User {
    private String password;
    private Long id;

    public User(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

// Define the UserRepository class
public class UserRepository_1 {
    private Encryptor encryptor;

    public UserRepository(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

    public void saveUser(User user) {
        // Encrypt sensitive fields
        user.setPassword(encryptor.encrypt(user.getPassword()));
        // Store the user in the database
        System.out.println("User saved with encrypted password: " + user.getPassword());
    }

    public User getUser(Long id) {
        // Retrieve the user from the database
        User user = new User(id, "encryptedPassword");
        // Decrypt sensitive fields
        user.setPassword(encryptor.decrypt(user.getPassword()));
        return user;
    }

    public static void main(String[] args) {
        // Create an instance of Encryptor
        Encryptor encryptor = new Encryptor() {
            @Override
            public String encrypt(String data) {
                // Simple encryption for demonstration purposes
                return data + "_encrypted";
            }

            @Override
            public String decrypt(String data) {
                // Simple decryption for demonstration purposes
                return data.replace("_encrypted", "");
            }
        };

        // Create an instance of UserRepository
        UserRepository userRepository = new UserRepository(encryptor);

        // Create a new User
        User user = new User(1L, "password");

        // Save the User
        userRepository.saveUser(user);

        // Retrieve the User
        User retrievedUser = userRepository.getUser(1L);

        // Print the decrypted password
        System.out.println("Decrypted password: " + retrievedUser.getPassword());
    }
}