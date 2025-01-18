import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@Entity
public class User_6 {
    private String username;
    private String passwd;
    @Enumerated(EnumType.STRING) // use STRING enum representation
    private UserType type;
}

enum UserType {
    ADMIN, NORMAL;

    public static void main(String[] args) {
    }
}