import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        YourEntity entity = (YourEntity) object;

        // Check if the ID is already set and within the specific range
        if (entity.getId() != null && entity.getId() >= 1 && entity.getId() <= 10000) {
            return entity.getId();
        }

        // Otherwise, generate a new ID, for example using a sequence or increment strategy
        String sql = "SELECT nextval('your_sequence')";
        long id = session.doReturningWork(connection -> {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                } else {
                    throw new HibernateException("No ID returned from sequence.");
                }
            } catch (SQLException e) {
                throw new HibernateException("Failed to execute SQL", e);
            }
        });

        return id;
    }

    public static void main(String[] args) {
        // Test code or execution entry point can be added here if necessary.
    }
}

// Supporting classes and interfaces to make the code compilable

class YourEntity {
    private Long id;

    public Long getId() {
        return id;
    }

    // Setter and other properties can be added as needed
}

interface IdentifierGenerator {
    Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException;
}

interface SharedSessionContractImplementor {
    <T> T doReturningWork(ReturningWork<T> work) throws HibernateException;
}

interface ReturningWork<T> {
    T execute(Connection connection) throws HibernateException;
}

class HibernateException extends RuntimeException {
    public HibernateException(String message) {
        super(message);
    }

    public HibernateException(String message, Throwable cause) {
        super(message, cause);
    }
}