import java.lang.annotation.*;

@Entity
public class User_12 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public static void main(String[] args) {
    }
}

// Define the annotations and related types
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Entity {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface GeneratedValue {
    GenerationType strategy();
}

enum GenerationType {
    IDENTITY
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();

    boolean nullable();
}