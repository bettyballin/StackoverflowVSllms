import java.lang.String;
import java.util.List;

public class MainClass {
    // Lazy List<User> example using Spring-Data

    public interface CrudRepository<T, ID> {
    }

    public class User {
    }

    public @interface Query {
        String value();
    }

    public @interface Param {
        String value();
    }

    public interface UserRepository extends CrudRepository<User, Long> {
        @Query("select u from Users u where u.group.name = :name")
        public List<User> findUsersByGroup(@Param("name") String name);
    }

    public static void main(String[] args) {
    }
}