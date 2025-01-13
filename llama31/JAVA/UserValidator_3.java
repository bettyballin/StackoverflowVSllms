import javax.validation.constraints.Email;

public class UserValidator_3_3 {
    @Email(message = "badEmail")
    private String email;

    public static void main(String[] args) {
    }
}