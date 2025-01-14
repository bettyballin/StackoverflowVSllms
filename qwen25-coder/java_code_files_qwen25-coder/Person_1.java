import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person_1 {
    @Id @GeneratedValue
    private Long id;
    // other fields...
}

@Entity
public class Employee extends Person_1 {
    private float salary;
    // other employee fields...
}

public class Main {
    public static void main(String[] args) {
    }
}