import java.lang.String;
import java.io.Serializable;

public class IdentifiableDaoInterface {
    public interface Identifiable<PK extends Serializable> {
        PK getUniqueId();
    }

    public interface GenericDao<PK extends Serializable, T extends Identifiable<PK>> {
        T findById(PK id);
    }
    public static void main(String[] args) {
    }
}