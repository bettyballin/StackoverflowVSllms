import javax.persistence.EntityManager;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@FilterDef(name = "regionFilter", parameters = { @ParamDef(name = "myRegion", type = "string") })
public class Employee {
    @Id
    private int id;
    private String name;

    // Constructors
    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
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
}

public class MainClass {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("my-persistence-unit").createEntityManager();
        Filter filter = em.unwrap(Session.class).enableFilter("regionFilter");
        filter.setParameter("myRegion", "someValue");
    }
}