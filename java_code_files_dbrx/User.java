import java.lang.String;
import javax.validation.constraints.NotEmpty;

public class User {
    @NotEmpty
    private String name;

    public static void main(String[] args) {
    }
}