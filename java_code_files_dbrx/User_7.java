import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User_7 {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Email(regexp="^[a-zA-Z0-9](\\.[_a-zA-Z0-9-]+)*@[A-Za-z.-]+(\\.[A-Za-z]{2,})$", message = "Invalid email address")
    private String email;

    public static void main(String[] args) {
    }

}