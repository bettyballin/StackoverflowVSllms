import java.io.Serializable;

public class GenericDaoContractorDaoInterfacewouldbesuitablenamesforthisinterface {
    public interface Identifiable<PK extends Serializable> {
        PK getUniqueId();
    }

    public interface GenericDao<T extends Identifiable<?>> {
        // Use wildcard for the return type and method parameter
        T findById(Object id);
    }

    public static void main(String[] args) {
    }
}