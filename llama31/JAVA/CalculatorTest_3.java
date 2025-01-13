import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class CalculatorTest_3_3 {

    @Container
    public PostgreSQLContainer<?> database = new PostgreSQLContainer<>("postgres:11")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");

    @Test
    public void testCalculator() throws Exception {
        Connection conn = DriverManager.getConnection(database.getJdbcUrl(), database.getUsername(), database.getPassword());
        Calculator calculator = new Calculator(conn);
        calculator.runCalculations();
        // Retrieve the results and compare with expected values
    }

    public static void main(String[] args) {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> {
            CalculatorTest_3 test = new CalculatorTest_3();
            test.testCalculator();
        });
    }
}