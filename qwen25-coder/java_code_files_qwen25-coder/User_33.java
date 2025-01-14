import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

public class User_33 {
    public static void main(String[] args) {
    }

    enum Type {
        ADMIN,
        USER,
        GUEST
    }

    @Entity
    class User {
        private String username;
        private String passwd;

        @Enumerated(EnumType.STRING)
        private Type type;

        // Getters and setters
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPasswd() { return passwd; }
        public void setPasswd(String passwd) { this.passwd = passwd; }

        public Type getType() { return type; }
        public void setType(Type type) { this.type = type; }
    }
}