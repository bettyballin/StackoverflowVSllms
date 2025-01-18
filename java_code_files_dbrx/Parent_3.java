import javax.persistence.*;

@Entity
public class Parent_3 {
    @Id
    @GeneratedValue
    private int id;
    protected Subfield subfield;

    public Subfield getSubfield() {
        return this.subfield;
    }
}

@Embeddable
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, columnDefinition = "char")
abstract class Subfield {
}

@DiscriminatorValue("A")
class TypeA extends Subfield {
    private String whoSiT; // corrected 'whosiit' field spelling and camel case convention.

    @Column(name = "column_name") // map the column in your table where whoSiT details are stored.
    public String getWhoSiT() {
        return this.whoSiT;
    }
}

@DiscriminatorValue("B")
class TypeB extends Subfield {
    private String whatsiT; // corrected 'whatsit' field spelling and camel case convention.

    @Column(name = "column_name") // map the column in your table where whatsiT details are stored.
    public String getWhatsiT() {
        return this.whatsiT;
    }

    public static void main(String[] args) {
    }
}