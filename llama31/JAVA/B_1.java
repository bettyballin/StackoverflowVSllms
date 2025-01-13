import javax.persistence.Entity;
import javax.persistence.Discriminator;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;

@Entity
@Discriminator(column = "type", type = DiscriminatorType.STRING)
public abstract class A {
    // ...
}

@Entity
@DiscriminatorValue("B")
public class B_1_1 extends A {
    // ...

    public static void main(String[] args) {
    }
}