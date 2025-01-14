import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LicenceQueryHelper {

    String hql = "SELECT dl FROM DriversLicence dl " +
                 "JOIN dl.licenceClasses lc1 WHERE lc1.name = 'Car' " +
                 "AND EXISTS (" +
                     "SELECT 1 FROM LicenceClass lc2 " +
                     "WHERE lc2.id = :motorbikeId AND lc2 MEMBER OF dl.licenceClasses" +
                 ")";

    public void executeQuery() {
        Session session = getSession(); // Assume this method returns a Hibernate Session

        Query<DriversLicence> query = session.createQuery(hql, DriversLicence.class);

        int motorbikeId = getMotorbikeId(); // You need to retrieve motorbikeId first

        query.setParameter("motorbikeId", motorbikeId);

        List<DriversLicence> resultList = query.getResultList();
    }

    private Session getSession() {
        // Implement this method to return a Hibernate Session
        return null;
    }

    private int getMotorbikeId() {
        // Implement this method to retrieve motorbikeId
        return 0;
    }

    public static void main(String[] args) {
        LicenceQueryHelper helper = new LicenceQueryHelper();
        helper.executeQuery();
    }
}

// Placeholder class definitions
class DriversLicence {
    // properties and methods
}

class LicenceClass {
    // properties and methods
}