import java.io.Serializable;

public class GenericDaoIdentifiableEntity {
    public interface Identifiable<PK extends Serializable> {
        PK getUniqueId();
    }

    // Instead of specifying generic types for T and PK separately, use an intersection type.
    public interface GenericDao<PK extends Serializable, T extends Identifiable<PK> & Identifiable<?>> {
        // Here we combine the bounds using "&" to create intersection type.
        // This means T should be both Identifiable with PK and Identifiable with any type,
        // ensuring that both have the same PK type.
        public T findById(PK id);
    }

    public static void main(String[] args) {
    }
}