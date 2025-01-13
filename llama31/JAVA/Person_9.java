import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.validator.ValidatorActionForm;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Person_9_9 {
    private String name;

    @NotNull(message = "Name is required")
    @Size(min = 5, max = 60, message = "Name must be between 5 and 60 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Invalid characters in name")
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
    }
}