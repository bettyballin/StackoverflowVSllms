import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class NativeQueryExample {
    public static void main(String[] args) {
        String hql = "SELECT /*+ INDEX(employees idx_employee_id) */ * FROM employees WHERE department_id = :deptId";
        Session session = null; // Obtain a Hibernate session here

        Query query = session.createNativeQuery(hql);
        query.setParameter("deptId", 10);
        List results = query.list();
    }
}