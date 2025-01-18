// User.java
import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add the mappedBy attribute to specify that this side is not responsible for managing the relationship
    @ManyToMany(mappedBy = "users", orphanRemoval = true, cascade = {CascadeType.ALL})
    private Set<Group> groups;

    // Constructors, getters, setters, and other methods as necessary
    public User() {
        this.groups = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}