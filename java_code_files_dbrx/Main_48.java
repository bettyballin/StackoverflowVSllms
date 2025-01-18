import org.hibernate.Criteria;
import org.hibernate.Session;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = null; // Initialize your Hibernate session here
    
        // Create Criteria Query
        Criteria criteria = session.createCriteria(MyTable.class);
        criteria.setMaxResults(15); // sets limit to 15 results
    
        // Execute the query and get the results
        List<MyClass> myObjects = criteria.list();
    }
}

class MyTable {
    // Entity fields and methods
}

class MyClass {
    // Class fields and methods
}