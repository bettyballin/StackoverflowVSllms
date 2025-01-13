import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

@Entity
public class User_17_17 {
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Address> addresses;

    // getters and setters
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public static void main(String[] args) {
    }
}

// Define the Address class
@Entity
class Address {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User_17 user;

    // getters and setters
    public User_17 getUser() {
        return user;
    }

    public void setUser(User_17 user) {
        this.user = user;
    }
}