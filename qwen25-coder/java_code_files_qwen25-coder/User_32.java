import java.lang.String;
import java.lang.Long;
import java.lang.annotation.*;

// Define annotations
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Entity {}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Id {}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface GeneratedValue {}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Repository {}

// Define JpaRepository interface
interface JpaRepository<T, ID> {}

// Entity class
@Entity
public class User_32 {
    @Id @GeneratedValue
    private Long id;
    private String name;
}

// Dummy User class
public class User {}

// Repository interface
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public static void main(String[] args) {
    }
}