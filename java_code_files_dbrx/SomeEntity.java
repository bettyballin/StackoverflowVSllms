import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class SomeEntity {
    @OneToMany(cascade = CascadeType.ALL)
    private TargetEntity targetEntity; // Here "targetEntity" is a single object reference rather than a collection

    public static void main(String[] args) {
    }
}

class TargetEntity {
    // Minimal implementation
}