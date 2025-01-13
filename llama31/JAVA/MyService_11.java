import java.io.IOException;
import java.util.Properties;

public class MyService_11_11 {
    private Properties sqlProperties;

    public MyService_11() throws IOException {
        sqlProperties = new Properties();
        sqlProperties.load(getClass().getResourceAsStream("/sql.properties"));
    }

    public void myMethod() {
        String query = sqlProperties.getProperty("FIND_ALL_BY_CHEAPEST_AND_PRODUCT_IDS");
        // Use the query with SimpleJdbcTemplate
    }

    public static void main(String[] args) {
        try {
            MyService_11 myService = new MyService_11();
            myService.myMethod();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}