// To compile this code with javac, include the required external libraries in the classpath.
// For example:
// javac -cp .:junit-jupiter-api-5.9.0.jar:mockito-core-4.6.1.jar YourClassTest.java

import javax.naming.*;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;

public class YourClassTest {

    @Test
    public void testYourMethod() throws NamingException, SQLException {
        // Mock the context and data source
        Context mockContext = Mockito.mock(Context.class);
        DataSource mockDataSource = Mockito.mock(DataSource.class);
        Connection mockConnection = Mockito.mock(Connection.class);

        // Configure the mock context to return the mock data source on lookup
        Mockito.when(mockContext.lookup("yourJndiName")).thenReturn(mockDataSource);

        // Configure the mock data source to return the mock connection when getConnection is called
        Mockito.when(mockDataSource.getConnection()).thenReturn(mockConnection);

        // Assuming your class has a method that takes a context as a parameter, use the mock here
        YourClass yourClass = new YourClass();

        try {
            DataSource dataSource = (DataSource) mockContext.lookup("yourJndiName");
            Connection conn = dataSource.getConnection();  // Utilize the mocked connection

            // Perform assertions on what your class does with the connection
            Mockito.verify(mockDataSource).getConnection();
        } finally {
            mockConnection.close();  // Ensure the mock connection is closed in a real setup
        }
    }
}

// Example of your legacy code with a slight modification to accept Context as a parameter for easier testing
class YourClass {
    public void someMethod(Context ctx) throws NamingException, SQLException {
        DataSource dataSource = (DataSource) ctx.lookup("yourJndiName");
        try (Connection conn = dataSource.getConnection()) {
            // Use the connection as needed
        }
    }

    public static void main(String[] args) {
        // Entry point
    }
}