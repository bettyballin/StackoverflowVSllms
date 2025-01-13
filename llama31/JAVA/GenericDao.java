import java.io.Serializable;

public class GenericDao {
    public interface Identifiable<PK extends Serializable> {
        PK getUniqueId();
    }

    public interface GenericDao<T extends Identifiable<?>> {
        public T findById(Object id);
    }

    public static void main(String[] args) {
    }
}