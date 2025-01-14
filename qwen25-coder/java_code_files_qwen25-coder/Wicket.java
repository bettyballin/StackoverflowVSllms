import java.lang.String;
import java.lang.Set;
import java.lang.Integer;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Wicket")
public class Wicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer w_id;

    // Other fields of Wicket class...

    @ElementCollection(targetClass = WicketType.class)
    @JoinTable(
        name = "Ref_Table",
        joinColumns = @JoinColumn(name = "W_ID")
    )
    @Column(name = "W_TypeId")
    @Enumerated(EnumType.ORDINAL) // or EnumType.STRING, depending on your ref table
    private Set<WicketType> types;

    // Getters and setters...
}

enum WicketType {
    TYPE_A,
    TYPE_B,
    TYPE_C;

    public static void main(String[] args) {
    }
}