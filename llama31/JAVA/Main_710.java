import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import com.sleepycat.db.Database;
import com.sleepycat.db.Environment;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_710 {
    public static void main(String[] args) throws Exception {
        // Create a Berkeley DB environment and database
        Environment env = new Environment(new File("mydb"), false);
        Database db = env.openDatabase(null, "mytable", null, null);

        // Create a QueryRunner instance
        QueryRunner queryRunner = new QueryRunner() {
            @Override
            protected Connection prepareConnection() throws SQLException {
                return DriverManager.getConnection("jdbc:sqlite:mydb/mytable");
            }
        };

        // Execute a query
        Object[] results = queryRunner.query("SELECT * FROM mytable WHERE foo=?", new Object[] {"bar"});

        // Close the database and environment
        DbUtils.closeQuietly(db);
        DbUtils.closeQuietly(env);
    }
}