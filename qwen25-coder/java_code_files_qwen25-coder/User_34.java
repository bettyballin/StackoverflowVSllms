public class User_34 {
    @NotBlank(message = "User name is mandatory")
    private String userName;

    // getter and setter methods

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) {
    }
}

// Minimal NotBlank annotation definition
@interface NotBlank {
    String message() default "";
}