import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import lombok.Data;

public class Parent_2 {

    @Valid  // Validate elements of this list.
    private List<Child> childList;

    // getters and setters
}

@Data
class Child {

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Email is required.")
    private String email;

    @NotNull(message = "Age must be provided.")
    @Min(value = 1, message = "Invalid age. Must be min 1 year old")
    private Integer age;

    public static void main(String[] args) {
    }
}