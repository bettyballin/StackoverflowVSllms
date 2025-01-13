import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Entity;

// Example using named queries
@Entity
@NamedQueries({
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
})
public class User_20 {
    // Class implementation...
}