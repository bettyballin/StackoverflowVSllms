import java.util.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        double max_length_value = 10.0; // Example value
        Session session = null; // Assume this is initialized properly

        Criteria crit = session.createCriteria(Boy.class);
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.property("name"));
        projList.add(Projections.id());
        projList.add(Subqueries.exists(
            DetachedCriteria.forClass(Kite.class, "k")
                .add(Restrictions.eqProperty("k.boyId", Property.forName("id")))
                .add(Restrictions.ge("k.length", new BigDecimal("1.0")))
                .add(Restrictions.le("k.length", new BigDecimal("max_length_value")))
        ));

        crit.setProjection(projList);
        List<Object[]> results = crit.list();

        // Now manually fetch and filter kites
        for (Object[] row : results) {
            String name = (String) row[0];
            Long id = (Long) row[1];
            Boy boy = session.get(Boy.class, id);
            // Filter kites in Java
            boy.setKites(filterKitesByLength(boy.getKites(), 1.0, max_length_value));
        }
    }

    // Define filterKitesByLength method:
    static List<Kite> filterKitesByLength(Set<Kite> kites, double minLength, double maxLength) {
        List<Kite> filteredKites = new ArrayList<>();
        for (Kite kite : kites) {
            if (kite.getLength().doubleValue() >= minLength && kite.getLength().doubleValue() <= maxLength) {
                filteredKites.add(kite);
            }
        }
        return filteredKites;
    }
}

// Entity classes
class Boy {
    private Long id;
    private String name;
    private Set<Kite> kites;

    public Long getId() { return id; }
    public String getName() { return name; }
    public Set<Kite> getKites() { return kites; }
    public void setKites(List<Kite> kites) { 
        this.kites = new HashSet<>(kites); 
    }
}

class Kite {
    private Long id;
    private BigDecimal length;

    public Long getId() { return id; }
    public BigDecimal getLength() { return length; }
}

// Minimal stub implementations for Hibernate classes
class Session {
    public Criteria createCriteria(Class<?> clazz) {
        return new CriteriaImpl();
    }

    public <T> T get(Class<T> clazz, Long id) {
        return null;
    }
}

interface Criteria {
    Criteria setProjection(ProjectionList projectionList);
    List<Object[]> list();
}

class CriteriaImpl implements Criteria {
    public Criteria setProjection(ProjectionList projectionList) {
        return this;
    }

    public List<Object[]> list() {
        return new ArrayList<Object[]>();
    }
}

class ProjectionList {
    public ProjectionList add(Object projection) {
        return this;
    }
}

class Projections {
    public static ProjectionList projectionList() {
        return new ProjectionList();
    }

    public static Object property(String propertyName) {
        return new Object();
    }

    public static Object id() {
        return new Object();
    }
}

class Subqueries {
    public static Object exists(DetachedCriteria dc) {
        return new Object();
    }
}

class DetachedCriteria {
    public static DetachedCriteria forClass(Class<?> clazz, String alias) {
        return new DetachedCriteria();
    }

    public DetachedCriteria add(Restriction restriction) {
        return this;
    }
}

class Restrictions {
    public static Restriction eqProperty(String propertyName, Property property) {
        return new Restriction();
    }

    public static Restriction ge(String propertyName, BigDecimal value) {
        return new Restriction();
    }

    public static Restriction le(String propertyName, BigDecimal value) {
        return new Restriction();
    }
}

class Property {
    public static Property forName(String propertyName) {
        return new Property();
    }
}

class Restriction {
    // Empty class for stubs
}