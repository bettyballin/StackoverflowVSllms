import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("overseas") // discriminator value for OverSeasAccount
public class OverSeasAccount extends AbstractAccount {
    @Override
    public void doStuff() { }

    public static void main(String[] args) {
    }
}

// Definition of AbstractAccount
abstract class AbstractAccount {
    public abstract void doStuff();
}