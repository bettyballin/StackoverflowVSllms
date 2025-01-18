import java.sql.Connection;
import java.util.List;

public class PersonSqlRepository implements PersonRepository {

    private Connection connection;

    @Override
    public List<Person> findAll() {
        // this method would have SQL query and code for mapping results to Person objects
        return null;
    }
}

interface PersonRepository {
    List<Person> findAll();
}

class Person {
    // empty implementation
}