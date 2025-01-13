import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

public class Person_1_1 {
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public static void main(String[] args) {
    }
}