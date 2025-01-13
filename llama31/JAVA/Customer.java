import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true, selectBeforeUpdate = false, dynamicInsert = true)
public class Customer {
    // ...
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private List<Address> addresses;
    // ...
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private List<Order> orders;
    // ...

    public static void main(String[] args) {
    }
}