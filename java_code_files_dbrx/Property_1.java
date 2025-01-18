import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Entity {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@interface Lob {
}

enum FetchType {
    EAGER,
    LAZY
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@interface Basic {
    FetchType fetch() default FetchType.EAGER;
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@interface Transient {
}

@Entity
public class Property {
    private EntityType type;

    private String stringvalue;
    private Double doubleValue;
    // Add other value fields as needed

    // This will not store anything due to @Transient.
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Transient
    public Object getValue() {
        if (type == null || type.getJavaClass() == null) {
            // Handle cases of unknown or unset "type".
            return null;
        } else if (String.class.isAssignableFrom(type.getJavaClass())) {
            return stringvalue;
        } else if (Double.class.isAssignableFrom(type.getJavaClass())) {
            return doubleValue;
        }
        // More conditions for other types can be added here
        else {
            return null;
        }
    }
}

class EntityType {
    public Class<?> getJavaClass() {
        // Implementation goes here
        return null;
    }
}