import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// User.java
@Entity
@Table(name = "users")
public class User_21_21 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void main(String[] args) {
        // Example usage
        User_21 user = new User_21();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        System.out.println("User Name: " + user.getName());
        System.out.println("User Email: " + user.getEmail());
    }
}