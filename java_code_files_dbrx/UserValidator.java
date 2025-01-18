import java.lang.String;
public class UserValidator {
    public void ValidateServerSide(User user) {
        if (!user.isValid()) {
            throw new IllegalStateException("Invalid input");
        }
    }
    public static void main(String[] args) {
    }
}

interface User {
    boolean isValid();
}