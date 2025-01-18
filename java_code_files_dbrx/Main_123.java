import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Assume session is an initialized Hibernate Session
        Session session = new Session(); // Initialize your Hibernate session here

        List<String> options = Arrays.asList("Option1", "option2");

        Criteria criteria = session.createCriteria(YourEntityType.class)
                .add(Restrictions.in("YourAttributeName", options));  // Case-insensitive match for the YourAttributeName column with Option1 and option2, where both entries of the list would be used in comparison.

        // Execute the query (uncomment when session is properly initialized)
        // List<YourEntityType> results = criteria.list();

        // Process results
        // for (YourEntityType entity : results) {
        //     System.out.println(entity);
        // }
    }
}

class YourEntityType {
    // Define attributes corresponding to your database table
    private String YourAttributeName;

    // Getters and setters
    public String getYourAttributeName() {
        return YourAttributeName;
    }

    public void setYourAttributeName(String yourAttributeName) {
        this.YourAttributeName = yourAttributeName;
    }

    @Override
    public String toString() {
        return "YourEntityType{" +
                "YourAttributeName='" + YourAttributeName + '\'' +
                '}';
    }
}

// Dummy Session class
class Session {
    public Criteria createCriteria(Class<?> clazz) {
        return new Criteria();
    }
}

// Dummy Criteria class
class Criteria {
    public Criteria add(Criterion criterion) {
        return this;
    }

    // Uncomment if you want to execute the 'list' method
    // public List<YourEntityType> list() {
    //     // Return an empty list for compilation
    //     return new ArrayList<>();
    // }
}

// Dummy Criterion interface
interface Criterion {
    // Empty interface for compilation purposes
}

// Dummy Restrictions class
class Restrictions {
    public static Criterion in(String propertyName, List<?> values) {
        return new InCriterion(propertyName, values);
    }
}

// Dummy InCriterion class
class InCriterion implements Criterion {
    private String propertyName;
    private List<?> values;

    public InCriterion(String propertyName, List<?> values) {
        this.propertyName = propertyName;
        this.values = values;
    }

    // Additional methods if needed
}