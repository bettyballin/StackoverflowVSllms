import javax.persistence.Entity;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;

public interface Account {
    void doStuff();
}

public abstract class AbstractAccount implements Account {
    // add common fields and methods here
}

@Entity
@DiscriminatorColumn(name = "account_type")
public abstract class AbstractAccountEntity extends AbstractAccount {
    // ...
}

@Entity
@DiscriminatorValue("overseas")
public class OverSeasAccount extends AbstractAccountEntity {
    // ...
}

@Entity
@DiscriminatorValue("overdrawn")
public class OverDrawnAccount extends AbstractAccountEntity {
    // ...

    public static void main(String[] args) {
    }
}