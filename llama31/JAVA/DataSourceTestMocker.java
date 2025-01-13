import java.lang.String;
import java.util.Set;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.mockito.Mockito;

public class DataSourceTestMocker {

    // Mock the InitialContext
    private InitialContext mockCtx = Mockito.mock(InitialContext.class);

    // Mock the DataSource
    private DataSource mockDataSource = Mockito.mock(DataSource.class);

    private String jndiName = "your_jndi_name"; // Define the JNDI name

    public DataSourceTestMocker() {
        // Set up the mock behavior
        Mockito.when(mockCtx.lookup(jndiName)).thenReturn(mockDataSource);
    }

    // Use the mock data source in your test code
    public void testDataSource() {
        DataSource dataSource = (DataSource) mockCtx.lookup(jndiName);
        // Perform your test logic here
    }

    public static void main(String[] args) {
        new DataSourceTestMocker().testDataSource();
    }
}