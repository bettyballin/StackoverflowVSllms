import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

public class YourEntityLoader {
    public List<YourEntity> loadEntitiesWithAllAssociations(EntityManager entityManager) {
        String jpql = "SELECT e FROM YourEntity e " +
                      "JOIN FETCH e.association1 " +
                      "JOIN FETCH e.association2.subAssociation";
        TypedQuery<YourEntity> query = entityManager.createQuery(jpql, YourEntity.class);
        return query.getResultList();
    }
}

@Entity
class YourEntity {
    @OneToOne
    private Association1 association1;

    @OneToOne
    private Association2 association2;

    // Constructors, getters, and setters can be added here
}

@Entity
class Association1 {
    // Fields, constructors, getters, and setters can be added here
}

@Entity
class Association2 {
    @OneToOne
    private SubAssociation subAssociation;

    // Constructors, getters, and setters can be added here
}

@Entity
class SubAssociation {
    // Fields, constructors, getters, and setters can be added here
}