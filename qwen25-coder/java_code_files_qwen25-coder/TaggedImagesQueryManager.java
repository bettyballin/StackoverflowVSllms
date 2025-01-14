import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class TaggedImagesQueryManager {

    public static void main(String[] args) {
        EntityManager entityManager = null; // Needs proper initialization

        String jpql =
            "SELECT i FROM Image i " +
            "JOIN i.imageToTags itt JOIN itt.tag t " +
            "WHERE t.name IN (:tags) " +
            "GROUP BY i.id " +
            "HAVING COUNT(DISTINCT t) >= :tagCount";

        TypedQuery<Image> query = entityManager.createQuery(jpql, Image.class);
        query.setParameter("tags", Arrays.asList("a", "b", "c"));
        query.setParameter("tagCount", 3);

        List<Image> images = query.getResultList();
    }
}

class Image {
    // Fields and methods for the Image class
}