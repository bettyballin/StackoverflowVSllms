import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.MetaValue;
import javax.persistence.*;
import java.util.List;

@AnyMetaDef(
    name = "AccountType",
    metaType = String.class,
    idType = Long.class,
    metaValues = {
        @MetaValue(value = "OverSeasAccount", targetEntity = OverSeasAccount.class),
        @MetaValue(value = "OverDrawnAccount", targetEntity = OverDrawnAccount.class)
    }
)
@Entity
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToAny(metaDef = "AccountType", metaColumn = @Column(name = "account_type"))
    @JoinColumn(name = "account_id")
    private List<Account> accounts;
}

public interface Account {
    void doStuff();
}

@Entity
@DiscriminatorValue("OverSeasAccount")
public class OverSeasAccount implements Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void doStuff() {
        // do overseas type stuff
    }
}

@Entity
@DiscriminatorValue("OverDrawnAccount")
public class OverDrawnAccount implements Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void doStuff() {
        // do overDrawn type stuff
    }

    public static void main(String[] args) {
    }
}