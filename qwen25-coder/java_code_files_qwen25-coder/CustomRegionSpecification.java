import java.util.List;
import javax.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

// Entity class
class YourEntity {
    private String region;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

// Specification implementation
public class CustomRegionSpecification implements Specification<YourEntity> {
    private final String userRegion;

    public CustomRegionSpecification(String userRegion) {
        this.userRegion = userRegion;
    }

    @Override
    public Predicate toPredicate(Root<YourEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.equal(root.get("region"), userRegion);
    }
}

// Repository interface
@Repository
interface YourEntityRepository extends JpaRepository<YourEntity, Long>, JpaSpecificationExecutor<YourEntity> {}

// Service layer with main method
public class Main {
    public static void main(String[] args) {
        YourEntityRepository yourEntityRepository = null; // Placeholder for the actual repository instance
        String userRegion = "someRegion";
        
        List<YourEntity> entities = yourEntityRepository.findAll(new CustomRegionSpecification(userRegion));
        // Process entities as needed
    }
}