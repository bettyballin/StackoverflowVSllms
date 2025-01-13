import java.lang.String;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

public enum UserType {}

public class UserAccount {
    @Enumerated(EnumType.ORDINAL)
    private UserType type;

    public static void main(String[] args) {
    }
}