import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.example.db.h2.Tables;

public class Main_660 {
    public static void main(String[] args) {
        // Create a connection
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a DSLContext
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);

            // Build a query
            Result<Record> result = context.select()
                  .from(Tables.CUSTOMER)
                  .join(Tables.ADDRESS).on(Tables.ADDRESS.CUSTOMER_ID.eq(Tables.CUSTOMER.ID))
                  .where(Tables.ADDRESS.CITY.eq("New York"))
                  .fetch();

            // Print the result
            result.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}