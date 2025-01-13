import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

public class User_18 {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class User_18Service {
    private final Validator validator;

    public UserService() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public void saveUser(@Valid User user) {
        // Manual validation
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            System.out.println("User is not valid!");
            for (ConstraintViolation<User> violation : violations) {
                System.out.println(violation.getMessage());
            }
            return;
        }

        // Save user logic
        System.out.println("Saving user: " + user.getName());
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User();
        user.setName("John Doe");
        userService.saveUser(user);
    }
}