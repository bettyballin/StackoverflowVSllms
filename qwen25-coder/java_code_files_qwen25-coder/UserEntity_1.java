import java.lang.String;
import net.java.ao.Entity;
import net.java.ao.Preload;

public class UserEntity_1 {
    @Preload
    public interface User extends Entity {
        public String getUsername();
        public void setUsername(String username);

        public String getEmail();
        public void setEmail(String email);
    }

    public static void main(String[] args) {
    }
}