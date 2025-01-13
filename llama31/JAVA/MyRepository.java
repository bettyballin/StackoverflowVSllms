import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Entity
class MyEntity {
    @Id
    private Long id;

    // getters and setters
}

@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {

    @Query("SELECT DISTINCT e FROM MyEntity e")
    List<MyEntity> findAllDistinct();
}

public class Main {
    public static void main(String[] args) {
        // you can't instantiate an interface, so you can't use MyRepository here
        // you would typically use Spring to create an instance of MyRepository
    }
}