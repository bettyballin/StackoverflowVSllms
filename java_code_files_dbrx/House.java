public @interface Entity { }

public @interface Id { }

public @interface GeneratedValue {
    GenerationType strategy() default GenerationType.AUTO;
}

public @interface Column {
    String name() default "";
    boolean nullable() default true;
    String columnDefinition() default "";
}

public enum GenerationType {
    AUTO,
    IDENTITY,
    SEQUENCE,
    TABLE
}

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
}

@Entity
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    // explicitly specify columns for insertion
    @Column(name = "street_name", nullable = false, columnDefinition = "default 'default name'")
    public String name;

    public static void main(String[] args) {
    }
}