import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ObjectRepository {
    private EntityManager em;

    public List<Object> getObjectsByRegion(User user, List<String> selectedRegions) {
        // In Repository Class
        String sql = "SELECT * FROM Objects WHERE region IN :regionList";
        Query query = em.createNativeQuery(sql);
        List<String> regions = new ArrayList<>();
        for (Region r : user.getRegions()) {
            if (selectedRegions.contains(r.getId())) {
                regions.add(r.getId());
            }
        }
        return query.setParameter("regionList", regions).getResultList();
    }

    public static void main(String[] args) {
    }
}

class User {
    public List<Region> getRegions() {
        return new ArrayList<>();
    }
}

class Region {
    public String getId() {
        return "";
    }
}