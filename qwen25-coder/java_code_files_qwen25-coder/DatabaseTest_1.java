import java.lang.String;
import org.dbunit.AbstractDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class DatabaseTest_1 extends AbstractDatabaseTester {
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("dataset.xml"));
    }
    // Test methods go here...

    public static void main(String[] args) {
    }
}