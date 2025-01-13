import java.lang.String;

// Commenting out annotations because they require JPA and possibly Hibernate
// @Entity
// @Table(name = "DEAL")
public class Deal {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Enumerated(EnumType.STRING)
    // @Type(type = "DealTypeEnumType")
    // @Column(name = "typeId")
    private DealType type;

    public enum DealType {
        // Example enum values
        TYPE1, TYPE2
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DealType getType() {
        return type;
    }

    public void setType(DealType type) {
        this.type = type;
    }

    public static void main(String[] args) {
        Deal deal = new Deal();
        deal.setId(1L);
        deal.setType(DealType.TYPE1);
        System.out.println("Deal ID: " + deal.getId());
        System.out.println("Deal Type: " + deal.getType());
    }
}