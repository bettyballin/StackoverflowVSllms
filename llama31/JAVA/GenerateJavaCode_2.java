import java.lang.String;
// Example usage of MyBatis Generator
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.sql.SQLException;

public class GenerateJavaCode_2_2 {
    public static void main(String[] args) {
        // Create a new MyBatis Generator instance
        MyBatisGenerator generator = new MyBatisGenerator(new DefaultShellCallback(true));

        // Configure the generator
        Configuration config = new Configuration();
        config.setClassPathEntry("driver.jar");
        config.setConnectionURL("jdbc:mysql://localhost:3306/mydb");
        config.setUserId("myuser");
        config.setPassword("mypassword");

        // Generate the Java code
        try {
            generator.generate(config);
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("InterruptedException: " + e.getMessage());
        } catch (InvalidConfigurationException e) {
            System.err.println("Invalid Configuration: " + e.getMessage());
        } catch (XMLParserException e) {
            System.err.println("XML Parser Exception: " + e.getMessage());
        }
    }
}