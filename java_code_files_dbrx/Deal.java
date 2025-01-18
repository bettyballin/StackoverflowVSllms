import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

public class Deal {
    @Id
    private Long id;

    private Long version; // optional for optimistic locking

    @Column(name = "typeId")
    @Enumerated(EnumType.STRING) // this will map the String value of the enum in the table
    private DealType type;

    public static void main(String[] args) {
    }

    public enum DealType {
        TYPE_A,
        TYPE_B
    }
}