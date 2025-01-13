import java.util.List;

import javax.persistence.Query;
import javax.persistence.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Assuming Image is an entity class
import your.package.name.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("SELECT i FROM Image i " +
            "JOIN i.imageToTags it " +
            "JOIN it.tag t " +
            "WHERE t.name IN (:tags) " +
            "GROUP BY i " +
            "HAVING COUNT(DISTINCT t) >= :tagCount")
    List<Image> findImagesWithTags(@Param("tags") List<String> tags, @Param("tagCount") int tagCount);

    public static void main(String[] args) {
    }
}