import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name = "user")
public class User {
    @Id
    private Long id;
    private String username;
    @Version // Ensuring the field acts as a version number for optimistic locking.
    private int version = 0;

    // Constructors
    public User() {
    }

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getVersion() {
        return version;
    }

    // No setter for version since it's managed by JPA
}