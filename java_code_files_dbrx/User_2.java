import javax.validation.constraints.NotEmpty;

public class User_2 {
    @NotEmpty(message = "{validation.username.empty}")
    private String username;

    //other attributes...

    public static void main(String[] args) {
    }
}