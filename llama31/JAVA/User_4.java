import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User_4_4 {
    @Id
    private Long id;
    private String name;
    @OneToOne
    private Address address;
    // getters and setters
}

@Entity
public class Address {
    @Id
    private Long id;
    private String street;
    private String city;
    // getters and setters

    public static void main(String[] args) {
    }
}