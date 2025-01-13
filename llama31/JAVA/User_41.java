import java.util.List;

// Define a Java object
public class User_41 {
    private int id;
    private String name;
    private String email;

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

// Define the Query and SortOrder classes
class Query<T> {
    private Class<T> clazz;

    public Query(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Query<T> where(String field, String value) {
        // implementation of where clause
        return this;
    }

    public Query<T> select(String... fields) {
        // implementation of select clause
        return this;
    }

    public Query<T> orderBy(String field, SortOrder order) {
        // implementation of order by clause
        return this;
    }

    public List<T> execute() {
        // implementation of query execution
        return null; // dummy implementation
    }
}

enum SortOrder {
    ASC, DESC
}

// Create a LINQ-like query
public class Main {
    public static void main(String[] args) {
        Query<User> query = new Query<>(User.class)
                .where("name", "John")
                .select("id", "email")
                .orderBy("id", SortOrder.ASC);

        // Execute the query and retrieve results
        List<User> results = query.execute();
    }
}