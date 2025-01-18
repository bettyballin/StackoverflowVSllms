import java.lang.String;

@Entity
@DiscriminatorValue("overdrawn") // discriminator value for OverDrawnAccount
public class OverDrawnAccount extends AbstractAccount{
    @Override
    public void doStuff() { }

    public static void main(String[] args) {
    }
}

abstract class AbstractAccount {
    public abstract void doStuff();
}

@interface Entity {}

@interface DiscriminatorValue {
    String value();
}