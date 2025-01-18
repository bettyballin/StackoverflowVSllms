import java.util.List;
import org.hibernate.Session;

public class EmployeeDAOorEmployeeRepositoryThisclasslikelyencapsulatesdataaccesstotheemployeesprovidingmethodsforCRUDoperationsTheDAOinEmployeeDAOstandsforDataAccessObjectandiscommonlyusedinJavaapplicationsaspartofadataaccesslayer {
    Session session;
    List<Employee> employees = session.createQuery("from Employee e where e.Address is not null").list();
    public static void main(String[] args) {
    }
}