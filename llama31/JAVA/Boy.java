import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.Where;

@Entity
public class Boy {
    @OneToMany(mappedBy = "boy", fetch = FetchType.EAGER)
    @Where(clause = "length >= 1")
    private java.util.Set<Kite> kites;
    // ...

    public static void main(String[] args) {
    }
}