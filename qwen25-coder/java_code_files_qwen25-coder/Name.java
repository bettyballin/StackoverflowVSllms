import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Embeddable {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Entity {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Embedded {}

@Embeddable
class Name {
    private String firstName;
    private String lastName;
}

@Entity
public class User {
    @Id
    private Long id;

    @Embedded
    private Name name;

    public static void main(String[] args) {
    }
}