import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class javaValidationAnnotationDemo {

    @NotNull(message = "Value must be selected")
    private String selectedOne; // use this for selectOne, e.g., a DropdownMenu

    @Size(min = 1, message = "At least one value should be picked!")
    @NotNull
    private List<String> selectedMany; // use this for selectMany, e.g., CheckboxGroupInput

    public static void main(String[] args) {
    }
}