// No need to import java.lang.String as it's imported by default
public class TransactionManager {
    // Renamed the interface to avoid name clash with the class
    public interface TransactionManagerInterface {
        void beginTransaction();
        void commitTransaction();
        void rollbackTransaction();
    }

    public static void main(String[] args) {
    }
}