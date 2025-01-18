import java.lang.String;

public class UnitOfWorkOperation {
    public interface TransactionalOperation {
        void perform(Session session) throws Exception; // This method represents a unit of work that needs access to Hibernate's Session object
    }
    public static void main(String[] args) {
    }
}

class Session {
    // Empty class to allow compilation
}