import java.lang.String;
import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.operation.OperationListener;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.testng.annotations.BeforeMethod;

public class DatabaseTest extends DBTestCase {

    public DatabaseTest(String name) {
        super(name);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream("test-dataset.xml"));
    }

    @BeforeMethod
    public void setUpDatabaseForTest() throws Exception {
        this.getConnection().getConfig().setProperty(DatabaseConfig.PROPERTY_OPERATION_LISTENER, new DatabaseOperationListener());
    }

    @Override
    protected IDatabaseTester newDatabaseTester() throws Exception {
        PropertiesBasedJdbcDatabaseTester tester = new PropertiesBasedJdbcDatabaseTester(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/testDB", "root", "password");
        return tester;
    }

    public void testInsertData() throws Exception {
        // Perform some insertion operation here

        ITable actualTable = getConnection().createQueryTable("test_table", "SELECT * FROM test_table WHERE some_column='some_value'");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        IDataSet expectedDataSet = builder.build(getClass().getResourceAsStream("expected-dataset.xml"));

        ITable expectedTable = expectedDataSet.getTable("test_table");
        Assertion.assertEquals(expectedTable, actualTable);
    }

    public static void main(String[] args) {
    }
}

class DatabaseOperationListener implements OperationListener {
    @Override
    public void operationSetUpStarted(DatabaseOperation operation) { }

    @Override
    public void operationSetUpFinished(DatabaseOperation operation) { }

    @Override
    public void operationTearDownStarted(DatabaseOperation operation) { }

    @Override
    public void operationTearDownFinished(DatabaseOperation operation) { }
}