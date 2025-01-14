import java.lang.annotation.*;

@Service
public class MyService_6 {

    @Autowired
    private MyRepository1 myRepository1;

    @Autowired
    private MyRepository2 myRepository2;

    @Transactional(value = "transactionManager1")
    public void doSomethingInDb1() {
        // Transactional code for database 1
        myRepository1.save(new Entity1());
    }

    @Transactional(value = "transactionManager2")
    public void doSomethingInDb2() {
        // Transactional code for database 2
        myRepository2.save(new Entity2());
    }

    public static void main(String[] args) {
        // Entry point for the application
    }
}

// Annotations
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Service {}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Autowired {}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Transactional {
    String value() default "";
}

// Interface and class definitions
interface MyRepository1 {
    void save(Entity1 entity);
}

interface MyRepository2 {
    void save(Entity2 entity);
}

class Entity1 {
    // Entity1 properties and methods
}

class Entity2 {
    // Entity2 properties and methods
}