import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class A {
    // ...
}

@Entity
public class B extends A {
    // ...

    public static void main(String[] args) {
    }
}