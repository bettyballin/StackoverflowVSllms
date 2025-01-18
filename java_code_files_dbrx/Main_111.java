import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> colValues = Arrays.asList(1, 2, 3);

        // Obtain an entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = emf.createEntityManager();

        TypedQuery<TableA> query = entityManager.createNamedQuery("findByColValues", TableA.class);
        query.setParameter("colValues", colValues);

        // Execute the query
        List<TableA> result = query.getResultList();

        // Process the results
        for (TableA item : result) {
            System.out.println(item);
        }

        // Close the entity manager
        entityManager.close();
        emf.close();
    }
}

@Entity
@NamedQueries({
    @NamedQuery(
        name = "findByColValues",
        query = "SELECT t FROM TableA t WHERE t.colValue IN :colValues"
    )
})
class TableA {
    @Id
    private int id;
    private int colValue;

    // Constructors
    public TableA() {}

    public TableA(int id, int colValue) {
        this.id = id;
        this.colValue = colValue;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public int getColValue() {
        return colValue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColValue(int colValue) {
        this.colValue = colValue;
    }

    @Override
    public String toString() {
        return "TableA [id=" + id + ", colValue=" + colValue + "]";
    }
}

// Annotations
@interface Entity {}

@interface Id {}

@interface NamedQueries {
    NamedQuery[] value();
}

@interface NamedQuery {
    String name();
    String query();
}

// Stub classes to simulate the JPA classes
class Persistence {
    public static EntityManagerFactory createEntityManagerFactory(String unitName) {
        return new EntityManagerFactory();
    }
}

class EntityManagerFactory {
    public EntityManager createEntityManager() {
        return new EntityManager();
    }

    public void close() {
        // Do nothing
    }
}

class EntityManager {
    public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
        return new TypedQuery<T>();
    }

    public void close() {
        // Do nothing
    }
}

class TypedQuery<T> {
    public TypedQuery<T> setParameter(String name, Object value) {
        return this;
    }

    public List<T> getResultList() {
        return new java.util.ArrayList<T>();
    }
}