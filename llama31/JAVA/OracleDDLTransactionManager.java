import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class OracleDDLTransactionManager {

    public static void main(String[] args) throws SQLException {
        // Create a separate connection for DDL statements
        DataSource ddlDataSource = new DriverManagerDataSource("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");

        // Create a transaction manager for the DDL connection
        PlatformTransactionManager ddlTransactionManager = new org.springframework.jdbc.datasource.DataSourceTransactionManager(ddlDataSource);

        // Use the DDL transaction manager for DDL statements
        TransactionTemplate ddlTransactionTemplate = new TransactionTemplate(ddlTransactionManager);
        ddlTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) throws SQLException {
                // Execute DDL statement
                ddlDataSource.getConnection().createStatement().execute("CREATE TABLE ...");
            }
        });
    }
}