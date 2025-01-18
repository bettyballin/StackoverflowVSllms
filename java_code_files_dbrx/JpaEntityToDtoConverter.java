import java.util.ArrayList;
import java.util.List;

public class JpaEntityToDtoConverter {

    EntityManager em = new EntityManager();

    {
        List<MyJpaEntity> result = em.createQuery("SELECT mje FROM ...").getResultList();
        List<MyJpaEntityDto> dtos = new ArrayList<>(result.size());
        for (MyJpaEntity entity: result) {
            MyJpaEntityDto dto = copyFrom(entity); // You need to write this method for mapping fields from jpaEntity to your DTO.
            dtos.add(dto);
        }
    }

    public static void main(String[] args) {
    }

    public MyJpaEntityDto copyFrom(MyJpaEntity entity) {
        // You need to write this method for mapping fields from jpaEntity to your DTO.
        return new MyJpaEntityDto();
    }

    public class EntityManager {
        public Query createQuery(String query) {
            // Dummy implementation for compilation
            return new Query();
        }
    }

    public class Query {
        public List<MyJpaEntity> getResultList() {
            // Dummy implementation for compilation
            return new ArrayList<>();
        }
    }

    public class MyJpaEntity {
        // Define fields and methods as needed
    }

    public class MyJpaEntityDto {
        // Define fields and methods as needed
    }
}