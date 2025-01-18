import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

public class EmployeeUpdateQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        EntityManager entityManager = emf.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Employee> updateQuery = cb.createCriteriaUpdate(Employee.class);
        Root<Employee> employeeRoot = updateQuery.from(Employee.class);
        updateQuery.set("salary", "newSalary");
        updateQuery.where(cb.equal(employeeRoot.get("region"), "myRegion"));
        entityManager.createQuery(updateQuery).executeUpdate();
    }
}

@Entity
class Employee {
    @Id
    private Long id;

    @Column
    private String salary;

    @Column
    private String region;

    // Getters and setters (optional for compilation)
}