import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

public class ImageFinderByTags {

    public static void main(String[] args) {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Image> cq = cb.createQuery(Image.class);
        Root<ImageToTag> imageToTagJoin = cq.from(ImageToTag.class);
        cq.select(imageToTagJoin.get("image"));
        List<Predicate> conditions = new ArrayList<>();
        // Assuming 'a','b' and 'c' tags are available as Tag objects tagA, tagB & tagC
        Tag tagA = new Tag("a");
        Tag tagB = new Tag("b");
        Tag tagC = new Tag("c");

        conditions.add(cb.equal(imageToTagJoin.get("tag"), tagA));
        conditions.add(cb.equal(imageToTagJoin.join("image").join("tags"), tagB));
        conditions.add(cb.equal(imageToTagJoin.join("image").join("tags"), tagC));

        // This will ensure that images having all tags a,b and c are returned
        cq.where(cb.and(conditions.toArray(new Predicate[0])));

        // Execute query
        List<Image> results = entityManager.createQuery(cq).getResultList();
    }

    private static EntityManager getEntityManager() {
        // Return a mock or null for compilation purposes
        return null;
    }

    // Placeholder classes
    public static class Image {
        // Fields and methods
    }

    public static class ImageToTag {
        // Fields and methods
    }

    public static class Tag {
        private String name;
        public Tag(String name) {
            this.name = name;
        }
        // Fields and methods
    }
}