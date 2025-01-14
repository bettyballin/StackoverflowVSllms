import java.lang.String;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User_37 {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Size(min=6, message="Password must be at least 6 chars long")
    private String password;

    // Getters and setters

    public static void main(String[] args) {
    }
}