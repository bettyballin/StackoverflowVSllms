import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConfigurator_2_2 {
    // example using Apache DBCP
    public static void main(String[] args) {
        BasicDataSource ds = new BasicDataSource();
        ds.setInitialSize(5);
        ds.setMaxTotal(10);
        ds.setMaxIdle(5);
    }
}