import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User_6_6 {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
    }
}