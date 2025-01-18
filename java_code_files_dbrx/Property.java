import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class Property {
}

class StringValue extends Property {
    @Column
    private String _value;
}

class DoubleValue extends Property {
    @Column
    private double _value;
}

class ClassRefValue extends Property {
    @ManyToOne
    EntityType referencedClass;
}

@Entity
class EntityType {
}