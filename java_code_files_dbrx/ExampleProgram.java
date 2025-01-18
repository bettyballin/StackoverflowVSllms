import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ExampleProgram {
    public static void main(String[] args) {
        Properties dbProps = new Properties();

        try {
            FileInputStream in = new FileInputStream("db.properties");
            dbProps.load(in);
            in.close();
        } catch (IOException e) {
            // Handle this exception if the properties file is not found
            e.printStackTrace();
        }

        try {
            Class.forName(dbProps.getProperty("db.driver"));
        } catch (ClassNotFoundException e1) {
            // Handle this exception if the driver is not found in your classpath
            // ...
            e1.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(
                dbProps.getProperty("db.url"),
                dbProps.getProperty("db.username"),
                dbProps.getProperty("db.password"));
            // Use the connection object 'conn' as needed
            // ...
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        }
    }
}