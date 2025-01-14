import javax.persistence.*;
import org.hibernate.annotations.Type;

class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Transient // Mark as transient to prevent Hibernate from persisting this directly
    protected Subfield subfield;

    private String type; // Represent the discriminator column

    private String whosit;
    private String whatsit;

    @PostLoad
    private void onLoad() {
        if ("A".equals(type)) {
            subfield = new TypeA();
            ((TypeA) subfield).setWhosit(whosit);
        } else if ("B".equals(type)) {
            subfield = new TypeB();
            ((TypeB) subfield).setWhatsit(whatsit);
        }
    }

    public Subfield getSubfield() { return subfield; }
}

@Embeddable
abstract class Subfield {}

@AttributeOverrides({
    @AttributeOverride(name = "whosit", column = @Column(name = "whosit"))
})
class TypeA extends Subfield {
    private String whosit;

    public String getWhosit() { return whosit; }
    public void setWhosit(String whosit) { this.whosit = whosit; }
}

@AttributeOverrides({
    @AttributeOverride(name = "whatsit", column = @Column(name = "whatsit"))
})
public class TypeB extends Subfield {
    private String whatsit;

    public String getWhatsit() { return whatsit; }
    public void setWhatsit(String whatsit) { this.whatsit = whatsit; }

    public static void main(String[] args) {
    }
}