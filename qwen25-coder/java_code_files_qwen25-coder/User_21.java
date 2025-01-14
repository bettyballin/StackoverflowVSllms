// User.java
public class User {
    private String email;
    private boolean activated;

    // Getters and setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isActivated() {
        return activated;
    }
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}

// UserRepository.java
public class UserRepository {
    public void save(User user) {
        // Logic to save the user
        System.out.println("User saved: " + user.getEmail());
    }
}

// UserService.java
public class UserService {
    private UserRepository userRepository;
    private EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public void registerUser(String userEmail) {
        User user = new User();
        user.setEmail(userEmail);
        user.setActivated(false);
        userRepository.save(user);

        // Notify the controller to send an activation email
        emailService.sendActivationEmail(user);
    }
}

// EmailService.java
public class EmailService {
    public void sendActivationEmail(User user) {
        // Logic to send email to user.getEmail()
        System.out.println("Sending activation email to " + user.getEmail());
    }
}

// RegistrationController.java
public class RegistrationController {
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    public void handleRegistration(String userEmail) {
        // Here, the controller delegates the task of registration and sending an email to the respective services.
        userService.registerUser(userEmail);
    }

    public static void main(String[] args) {
        // Initialize dependencies
        UserRepository userRepository = new UserRepository();
        EmailService emailService = new EmailService();
        UserService userService = new UserService(userRepository, emailService);
        RegistrationController controller = new RegistrationController(userService);
        controller.handleRegistration("user@example.com");
    }
}