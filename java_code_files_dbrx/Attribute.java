import java.util.Set;

// Dummy versions of annotations and enums
@interface Id {}

@interface ManyToOne {
    FetchType fetch() default FetchType.LAZY;
}

@interface OneToMany {
    String mappedBy() default "";
    FetchType fetch() default FetchType.LAZY;
    CascadeType[] cascade() default {};
}

@interface JoinColumn {
    String name() default "";
}

@interface Any {
    String metaColumn() default "";
}

enum FetchType {
    LAZY,
    EAGER
}

enum CascadeType {
    ALL,
    PERSIST,
    MERGE,
    REMOVE,
    REFRESH,
    DETACH
}

// Classes
class Attribute {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id")
    @Any(metaColumn = "attribute_type")
    private Entity entity;

    // ... getters and setters omitted for brevity
}

public class Entity {
    public static final String ATTRIBUTE_VARCHAR = "varchar";

    @Id
    private Long id;

    @OneToMany(mappedBy = "entity", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<Attribute> attributes;

    // ... getters and setters omitted for brevity

    public static void main(String[] args) {
    }
}