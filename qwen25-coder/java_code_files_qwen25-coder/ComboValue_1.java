@Entity
@Table(name = "COMBO_VALUES")
public class ComboValue {

    @EmbeddedId
    private ComboValueId id;

    @Column(name = "VALUE", length = 100, nullable = false)
    private String value;

    // Constructors, getters and setters
    public ComboValue() {}

    public ComboValue(ComboValueId id, String value) {
        this.id = id;
        this.value = value;
    }

    public ComboValueId getId() {
        return id;
    }

    public void setId(ComboValueId id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
    }
}

// Empty class definition for ComboValueId
class ComboValueId {
    // Empty class body
}

// Annotation definitions
@interface Entity {}

@interface Table {
    String name();
}

@interface EmbeddedId {}

@interface Column {
    String name();
    int length();
    boolean nullable();
}