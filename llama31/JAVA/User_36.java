import javax.persistence.Entity;
import javax.persistence.Type;

@Entity
public class User_36_36 {
    @Type(type = "com.example.EnumUserType")
    private UserType type;
    
    // getters and setters

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public static void main(String[] args) {
    }
}

// Assuming UserType is an enum
enum UserType {
    // Add your enum values here
}