import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractAccount implements Account {
    // add common fields and methods here for all types of accounts, i.e., account number...

    public static void main(String[] args) {
    }
}

interface Account {
    // interface methods
}