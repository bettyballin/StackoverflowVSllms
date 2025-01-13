import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;

@Entity
public class Property {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private EntityType type;

    @OneToOne(mappedBy = "property")
    private Value value;
}

@Entity
@DiscriminatorColumn(name = "value_type")
public abstract class Value {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Property property;

    public abstract Object getValue();
}

@Entity
@DiscriminatorValue("string")
public class StringValue extends Value {
    private String value;

    public String getValue() {
        return value;
    }
}

@Entity
@DiscriminatorValue("double")
public class DoubleValue extends Value {
    private Double value;

    public Double getValue() {
        return value;
    }
}

@Entity
@DiscriminatorValue("object")
public class ObjectValue extends Value {
    private Object value;

    public Object getValue() {
        return value;
    }

    public static void main(String[] args) {
    }
}

@Entity
public class EntityType {
    @Id
    @GeneratedValue
    private Long id;

    // Add any additional fields or methods as needed
}