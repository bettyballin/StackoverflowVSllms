import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Customer_4_4 {
    @Embedded
    private Address address;
}

@Embeddable
class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public static void main(String[] args) {
    }
}