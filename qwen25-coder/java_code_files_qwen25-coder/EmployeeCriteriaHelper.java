import java.util.List;

public class EmployeeCriteriaHelper {
    Session session = new Session();
    Criteria criteriaE1;
    List results;

    {
        criteriaE1 = session.createCriteria(Employee.class, "e1");
        criteriaE1.createAlias("manager", "e1Manager");
        criteriaE1.add(Restrictions.sqlRestriction("{alias}.managerEmployeeID = {e1Manager}.employeeID"));
        criteriaE1.createCriteria(Employee.class, "e2");
        results = criteriaE1.list();
    }

    public static void main(String[] args) {
    }
}

class Session {
    public Criteria createCriteria(Class clazz, String alias) {
        return new Criteria();
    }
}

class Criteria {
    public void createAlias(String associationPath, String alias) {
    }

    public Criteria add(Object criterion) {
        return this;
    }

    public Criteria createCriteria(Class clazz, String alias) {
        return new Criteria();
    }

    public List list() {
        return null;
    }
}

class Restrictions {
    public static Object sqlRestriction(String sql) {
        return null;
    }
}

class Employee {
    // properties and methods
}