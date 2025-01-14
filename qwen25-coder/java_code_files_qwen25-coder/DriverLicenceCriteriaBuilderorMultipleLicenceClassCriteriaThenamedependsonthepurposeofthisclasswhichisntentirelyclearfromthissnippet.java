import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

public class DriverLicenceCriteriaBuilderorMultipleLicenceClassCriteriaThenamedependsonthepurposeofthisclasswhichisntentirelyclearfromthissnippet {

    public static void main(String[] args) {
        Session session = null; // Assume session is initialized elsewhere

        Criteria criteria = session.createCriteria(DriversLicence.class);
        criteria.createAlias("licenceClasses", "lc");
        
        // Subquery to find licenses with 'Car'
        DetachedCriteria carLicenseSubquery = DetachedCriteria.forClass(DriversLicence.class, "d")
                .createAlias("d.licenceClasses", "lc")
                .add(Restrictions.eq("lc.name", "Car"))
                .setProjection(Projections.property("d.id"));
        
        // Subquery to find licenses with 'Motorbike'
        DetachedCriteria motorbikeLicenseSubquery = DetachedCriteria.forClass(DriversLicence.class, "dm")
                .createAlias("dm.licenceClasses", "lcm")
                .add(Restrictions.eq("lcm.name", "Motorbike"))
                .setProjection(Projections.property("dm.id"));
        
        // Combine both subqueries with an AND condition
        criteria.add(Subqueries.propertyIn("id", carLicenseSubquery))
                .add(Subqueries.propertyIn("id", motorbikeLicenseSubquery));
        
        List<DriversLicence> resultList = criteria.list();
    }
}

class DriversLicence {
    public int id;
    public List<LicenceClass> licenceClasses;
}

class LicenceClass {
    public String name;
}