import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

public class MyRepository_1_1 {
    @Repository
    public interface MyRepository extends JpaRepository<MyEntity, Long> {

        @EntityGraph(attributePaths = {"relationships"})
        @Query("SELECT DISTINCT e FROM MyEntity e")
        List<MyEntity> findAllDistinct();
    }

    public static void main(String[] args) {
    }
}