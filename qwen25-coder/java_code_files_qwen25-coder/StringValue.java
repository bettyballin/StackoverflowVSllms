import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "value_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

@Entity
@DiscriminatorValue("STRING")
public class StringValue extends Value {
    private String stringValue;

    // getters and setters
}

@Entity
@DiscriminatorValue("DOUBLE")
public class DoubleValue extends Value {
    private Double doubleValue;

    // getters and setters
}

@Entity
@DiscriminatorValue("ENTITY")
public class EntityValue extends Value {
    @ManyToOne
    private AnotherEntity entity;  // AnotherEntity is the type of object you're linking to

    // getters and setters
}

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private EntityType type;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Value value;

    // getters and setters

    public static void main(String[] args) {
    }
}

@Entity
public class AnotherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Additional fields and methods if necessary
}

@Entity
public class EntityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Additional fields and methods if necessary
}