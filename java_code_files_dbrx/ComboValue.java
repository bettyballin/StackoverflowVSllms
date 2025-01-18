import java.lang.String;

@Entity
public final class ComboValue {
    @Id
    private java.security.KeyPair id;

    @Column(name = "KEY")
    private String key;

    @ManyToOne
    private ComboType type;

    @Column(name = "VALUE", nullable = false)
    private String value;

    public static void main(String[] args) {
    }
}

// Define the missing class
class ComboType {
}

// Define the missing annotations
@interface Entity {}

@interface Id {}

@interface Column {
    String name();
    boolean nullable() default true;
}

@interface ManyToOne {}