import java.lang.String;
import java.lang.Integer;

public class FieldRuleHelper {
    public static void main(String[] args) {
        MyEntityManager em = new MyEntityManager();

        // Create SeaSearchRule object
        SeaSearchRule searchRule = new SeaSearchRule();
        searchRule.setName("example"); // set other fields
        em.persist(searchRule); // persist the parent object to generate ID
        Integer primaryKey = searchRule.getId(); // obtain the generated id

        // Create FieldRule object and assign parent's primary key
        FieldRule fieldRule1 = new FieldRule();
        fieldRule1.setSearchRuleID(primaryKey);
        em.persist(fieldRule1);
    }
}

class MyEntityManager {
    public void persist(Object o) {
        // Implementation here
    }
}

class SeaSearchRule {
    private Integer id = 1; // Simulated generated ID
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}

class FieldRule {
    private Integer searchRuleID;

    public void setSearchRuleID(Integer id) {
        this.searchRuleID = id;
    }
}