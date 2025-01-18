import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Other fields, constructors, and getters/setters
    private String zipCode;

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
        // add logic here if needed
    }

    public static void main(String[] args) {
        // Entry point of the program
    }
}