import java.util.List;
import java.util.ArrayList;

public class DualLicenseFinder {
    public List<License> findByBothClasses(String car, String motorcycle) {
        DetachedCriteria carCriteria = DetachedCriteria.forClass(License.class)
            .createAlias("licenseClasses", "lc")
            .add(Restrictions.eq("lc.name", car));

        DetachedCriteria bikeCriteria = DetachedCriteria.forClass(License.class)
            .createAlias("licenseClasses", "lc")
            .add(Restrictions.eq("lc.name", motorcycle));

        Criteria criteria = getSession().createCriteria(License.class);
        criteria.add(Subqueries.propertyIn("id", carCriteria))
                .add(Subqueries.propertyIn("id", bikeCriteria));

        return criteria.list();
    }

    public static void main(String[] args) {
    }

    private Session getSession(){
        // return stub Session instance
        return new Session();
    }
}

class License {
    // empty class
}

class DetachedCriteria {
    public static DetachedCriteria forClass(Class<?> clazz){
        return new DetachedCriteria();
    }
    public DetachedCriteria createAlias(String associationPath, String alias){
        return this;
    }
    public DetachedCriteria add(Object criterion){
        return this;
    }
}

class Restrictions {
    public static Object eq(String propertyName, Object value){
        return new Object();
    }
}

class Criteria {
    public Criteria add(Object criterion){
        return this;
    }
    public List<License> list(){
        return new ArrayList<License>();
    }
}

class Subqueries {
    public static Object propertyIn(String propertyName, DetachedCriteria dc){
        return new Object();
    }
}

class Session {
    public Criteria createCriteria(Class<?> clazz){
        return new Criteria();
    }
}