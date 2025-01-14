import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

// other imports

public class Person {

    private String firstName;

    @NotEmpty(message = "{firstName.isEmpty}")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}