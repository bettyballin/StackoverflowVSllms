import java.util.EnumSet;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.Enumerated;
import javax.persistence.ElementCollection;
import javax.persistence.Column;
import javax.persistence.EnumType;

@Entity
public class Wicket {
    @Id
    private int id;

    // other fields...

    @CollectionTable(name = "Ref_Table", joinColumns = @JoinColumn(name = "W_ID"))
    @Enumerated(EnumType.STRING)
    @ElementCollection
    @Column(name="W_TYPEID")
    private EnumSet<WicketType> types;

    public static void main(String[] args) {
    }
}

enum WicketType {
    TYPE1,
    TYPE2
}