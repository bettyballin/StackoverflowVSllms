import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

public enum UserType {
    ADMIN,
    NORMAL
}

@Entity
public class User_35_35 {
    @Enumerated(EnumType.STRING)
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