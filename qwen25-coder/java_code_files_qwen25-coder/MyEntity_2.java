import java.util.Map;
import java.util.HashMap;

// Dummy annotations and enums to mimic javax.persistence package
@interface Entity {
}

@interface Id {
}

@interface GeneratedValue {
    GenerationType strategy() default GenerationType.AUTO;
}

enum GenerationType {
    AUTO,
    IDENTITY,
    SEQUENCE,
    TABLE
}

@interface ElementCollection {
    FetchType fetch() default FetchType.LAZY;
}

enum FetchType {
    LAZY,
    EAGER
}

@interface CollectionTable {
    String name() default "";
    JoinColumn[] joinColumns() default {};
}

@interface JoinColumn {
    String name() default "";
}

@interface MapKeyColumn {
    String name() default "";
}

@interface Column {
    String name() default "";
}

@Entity
public class MyEntity_2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "my_entity_map", joinColumns = @JoinColumn(name = "entity_id"))
    @MapKeyColumn(name = "map_key")
    @Column(name = "map_value")
    private Map<String, String> myMap = new HashMap<>();

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public static void main(String[] args) {
        // You can add code here to test your class
    }
}